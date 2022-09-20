/* (c) Copyright 2020 Paul Nguyen. All Rights Reserved */

package umlparser ;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Main Entry Point.
 */
final class Main {

    private static boolean DEBUG = false ;

    /**
     * Prevent Construction.
     */
    private Main() {
        // Utility Class
        return ;
    }

    /**
     * Create Dummy File
     * @param dir directory location for file
     * @param file file to create (.ext included)
     */
    private static void touch ( String dir, String filename ) {
        File file = new File( dir, filename ) ;
        if ( !file.exists() ) {
            try {
                file.createNewFile()  ;
            } catch ( Exception e ) {
                System.out.println( e ) ;
            }
        }
    }

    /**
     * [copyInputStreamToFile description]
     * @param  inputStream [description]
     * @param  filename    [description]
     * @throws IOException [description]
     */
    private static void copyInputStreamToFile(InputStream inputStream, String filename)
    throws IOException {

        File file = new File( filename );
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }


    /*
    * Utility to Pretty Print Objects as JSON  
    *
    * REF:  https://github.com/google/gson
    *       https://github.com/google/gson/blob/master/UserGuide.md
    */
    public static void printJSON(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(object));
    }


    /**
     * Main App Entry Point.
     * @param args base-dir test-case
     */
    public static void main(final String[] args) throws Exception {

        if ( DEBUG ) {
            System.out.printf( "[DEBUG] UML Parser #Args: %d%n", args.length ) ;
            for (int i = 0; i < args.length; i++)  {
                System.out.printf( "[DEBUG] args[%d] = %s%n", i, args[i] );
            }
        }

        if ( args.length == 2 ) {

            String basedir = args[0] ;
            String testcase = args[1] ;
            String testdir = basedir + File.separator + "testcases" + File.separator + testcase ;
            String outdir = basedir + File.separator + "output" + File.separator + testcase ;
            if ( DEBUG ) {
                System.out.printf("basedir: %s%n", basedir) ;
                System.out.printf("testdir: %s%n", testdir) ;
                System.out.printf("outdir: %s%n", outdir) ;             
            }

            /**
             * Parse Test Directory
             */

            File projectdir = new File(testdir) ;

            if (DEBUG) {
                System.out.println("") ;   
                System.out.println("***** CLASSES *****\n");
                DSL.listClasses(projectdir) ;
                 System.out.println("***** METHODS *****\n");
                DSL.listMethods(projectdir) ;
                System.out.println("***** FIELDS *****\n");
                DSL.listFields(projectdir) ;                
            }

            System.out.println("") ; 
            System.out.println("***** JAVA PARSER *****\n");

            DSL yuml_dsl_generator = new DSL(projectdir) ;
            String yuml_dsl = yuml_dsl_generator.generate() ;
            String yuml_json = yuml_dsl_generator.getJSON() ;


            /* 
            ** Generate UML Diagram
            */
            System.out.println("") ; 
            if ( testcase.equals("sequence") ) {
                System.out.println("***** SEQUENCE DIAGRAM *****\n");
                touch(outdir, testcase + ".seq") ;  // sequence source
                touch(outdir, testcase + ".jpg") ;  // sequence output
            } else {    
                System.out.println("***** YUML CLASS DIAGRAM *****\n");
                YUML uml = new YUML( basedir ) ;
                String image = uml.generate( yuml_dsl, yuml_json, testcase ) ;
                System.out.println("Generated: " + image) ;
            }

        } else {
            System.out.println( "java -cp [jar file].jar umlparser.Main [base directory] [test case]" ) ;
        }


    }

}

