/* (c) Copyright 2020 Paul Nguyen. All Rights Reserved */

package umlparser ;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.HashMap; 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
    Java Parser

    https://javaparser.org
    https://github.com/javaparser
    https://github.com/ftomassetti/analyze-java-code-examples
    https://www.javadoc.io/doc/com.github.javaparser/javaparser-core/latest/index.html
    
 */

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.NodeList.*;
import com.github.javaparser.ast.expr.*;
import com.google.common.base.Strings;


/**
 *  yUML DSL Generator
 */
class DSL {

    private static boolean DEBUG_LIST = false ;    
    private static boolean DEBUG_PARSE = true ;
    private static boolean DEBUG_DSL = true ;
    private static boolean DEBUG_USES = true ;    
    private static boolean DEBUG_COMPARTMENTS = true ;

    private File project_directory ;
    private String json_document ;
    private HashMap<String, UMLClassifier> classifiers = new HashMap<>() ; 
    private HashMap<String, UMLRelationship> relationships = new HashMap<>() ;

    public DSL( File projdir ) {
        this.project_directory = projdir ;
    }

    public String getJSON() {
        return this.json_document ;
    }

    public String generate() {

        // 1st pass to get Classifiers (Classes & Interface Definitions)
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                        super.visit(n, arg);
                        if ( n.isInterface()  ) {

                             if (DEBUG_PARSE) 
                                System.out.println("Interface: " + n.getName());

                             UMLClassifier obj1 = new UMLClassifier() ;
                             obj1.name = n.getName().toString() ;
                             obj1.type = "interface" ;
                             classifiers.put(obj1.name,obj1) ;

                        }
                        else {
                            
                            String exts = n.getExtendedTypes().toString() ;
                            String impl = n.getImplementedTypes().toString() ;

                            if (DEBUG_PARSE) {
                                System.out.println("Class: " + n.getName());
                                System.out.println("   Extends:    " + exts  ) ;
                                System.out.println("   Implements: " + impl  ) ;                                
                            }
                            
                            UMLClassifier obj2 = new UMLClassifier() ;
                            obj2.name = n.getName().toString() ;
                            obj2.type = "class" ;
                            obj2.parse( exts, impl ) ;
                            classifiers.put(obj2.name, obj2) ;
                        }
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(project_directory);       


        /** 
            =========================
            Final Pass - Generate DSL 
            =========================
        **/

        String dsl_output = "" ;
        String dsl_attributes = "" ;
        String dsl_operators = "" ;

        // Classes
        for (Map.Entry<String, UMLClassifier> e : classifiers.entrySet()) {
            
            String key = e.getKey() ; 
            UMLClassifier theClass = e.getValue() ;
            
            // Interface or Class?
            if (theClass.type.equals("interface")) {
                dsl_output = dsl_output + "[<<interface>>;" + theClass.name + "]," ;
            }
            else {
                dsl_output = dsl_output + "[" + theClass.name + "]," ;
            }
            
        }


        // Final DSL Output
        if (DEBUG_DSL)  {
            System.out.println( " " ) ;
            System.out.println( "DSL GENERATAED:\n\n" + dsl_output ) ;
        }


        // Save & Print JSON Document
        Gson gson = new GsonBuilder().setPrettyPrinting().create() ;
        UMLModel dsl_document = new UMLModel() ;
        dsl_document.classifiers = classifiers ;        
        dsl_document.relationships = relationships ;
        this.json_document = gson.toJson(dsl_document).toString() ;
        System.out.println("") ; 
        System.out.println( this.json_document ) ;
        System.out.println("") ; 

        return dsl_output ;

    }



    /**
    **
    **  DEBUG LISTING EXPERIMENTS
    **
    */


    public static void listClasses(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            if (DEBUG_LIST) {
                System.out.println(path);
                System.out.println(file);
                System.out.println(Strings.repeat("=", path.length()));
            }

            try {
                CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(file));
                cu.findAll(FieldDeclaration.class).forEach(field -> {
                    field.getVariables().forEach(variable -> {
                        if (DEBUG_LIST)
                            System.out.println("Class Field: " + variable.getType() + " " + variable.getName());
                    });
                });
            } catch (Exception e) {}


            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                        super.visit(n, arg);
                        if ( n.isInterface()  )
                            if (DEBUG_LIST) 
                                System.out.println("Interface: " + n.getName());
                        else {
                            String exts = n.getExtendedTypes().toString() ;
                            String impl = n.getImplementedTypes().toString() ;
                            if (DEBUG_LIST) {
                                System.out.println("Class: " + n.getName());
                                System.out.println("   Extends:    " + exts ) ;
                                System.out.println("   Implements: " + impl ) ;
                            }
                        }
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(projectDir);
    }


    public static void listMethods(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            if (DEBUG_LIST) {
                System.out.println(path);
                System.out.println(Strings.repeat("=", path.length()));
            }
            try {
                new VoidVisitorAdapter<Void>() {
                    @Override
                    public void visit(MethodDeclaration md, Void arg) {
                        super.visit(md, arg);
                        String name = md.getName().toString() ;
                        String decl = md.getDeclarationAsString(true, false, true) ;
                        if (DEBUG_LIST) 
                            System.out.println("Method: " + decl);
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(projectDir);
    }


    public static void listFields(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {

            if (DEBUG_LIST) {
                System.out.println(path);
                System.out.println(Strings.repeat("=", path.length()));
            }

            try {
                new VoidVisitorAdapter<Void>() {
                    @Override
                    public void visit(VariableDeclarator vd, Void arg) {
                        super.visit(vd, arg);
                        String type = vd.getType().toString() ;
                        String name = vd.getName().toString() ;
                        if (DEBUG_LIST)  {
                            System.out.println( "Variable Type " + type ) ;      
                            System.out.println( "Variable Name " + name ) ;                    
                        }
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                new VoidVisitorAdapter<Void>() {
                    @Override
                    public void visit(VariableDeclarationExpr vd, Void arg) {
                        super.visit(vd, arg);
                        String variable = vd.getVariables().toString() ;
                        if (DEBUG_LIST)  {
                            System.out.println( "Variable " + variable ) ;                        
                        }
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                new VoidVisitorAdapter<Void>() {
                    @Override
                    public void visit(FieldDeclaration fd, Void arg) {
                        super.visit(fd, arg);
                        String type = fd.getVariables().get(0).getType().toString() ;
                        String variable = fd.getVariables().get(0).toString() ;
                        String modifier = "" ;
                        try { modifier = fd.getModifiers().get(0).toString() ; } catch (Exception e) {}
                        if (DEBUG_LIST) 
                            System.out.println( "Class Variable: " + modifier + " " + type + " " + variable ) ;                        
                    }
                }.visit(StaticJavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).explore(projectDir);
    }


}

