/* (c) Copyright 2020 Paul Nguyen. All Rights Reserved */

package umlparser ;

import java.util.*; 

class UMLMethod {

	private static boolean DEBUG = true ;  

	public String signature ;
	public String methodName ;
	public String returnType ; 
	public String visibility ;
	public boolean isClassMethod ; 
	public String javaReturnType ;
	public List<UMLArg> arguments = new ArrayList<UMLArg>() ; 
	public List<String> modifiers = new ArrayList<String>() ;


	/**
		Parse Method Spec as follows:

		public void test(A2 a2, A1 a1) 			=> +test(at:A2, a1:A1):void  
		private void test(A2 a2, A1 a1) 		=> -test(at:A2, a1:A1):void  
		String test(A2 a2, A1 a1) 				=> test(at:A2, a1:A1):String
		public static void main(String[] args)	=> *+main(args:String[*]):void*
		static void test()						=> *test():void*

	**/
	public void parse() {

		// parse visibility, return type and method name
		String[] s1 = this.signature.trim().split("\\(") ;
		if (DEBUG) System.out.println( "s1: " + Arrays.toString(s1) ) ;
		
		String[] s2 = s1[0].trim().split("\\s+") ;
		if (DEBUG) System.out.println( "s2: " + Arrays.toString(s2) ) ;			

		//  Sample s2 array values:
		//
		//  [public, static, void, main]
		//  [public, static, final, void, main]
		//  [static, final void, main]
		//  [public, final, void, main]
		//

		this.visibility = " " ; 
        this.returnType = "" ;
        this.methodName = "" ;		
        this.isClassMethod = false ;	

        int s2_len = s2.length ;
        this.methodName = s2[s2_len-1] ;
        this.javaReturnType = s2[s2_len-2] ;
        this.returnType = parse_type(s2[s2_len-2]) ;

        for ( int i = s2_len-3 ; i>=0 ; i-- ) {
        	String token = s2[i] ;
        	this.modifiers.add( token ) ;
			if ( token.equals("private") )
            	this.visibility = "-" ;
        	else if ( token.equals("public") ) 
            	this.visibility = "+" ;     
           	else if ( token.equals("protected") )
        		this.visibility = "#" ;           		
           	else if ( token.equals("static") )
        		this.isClassMethod = true ;           
        }

		// parse arguments
		String[] args1 = s1[1].trim().split("\\)") ;
		if (DEBUG) System.out.println( "args1: " + Arrays.toString(args1) ) ;
		if ( args1.length > 0 ) {
			String[] args2 = args1[0].trim().split(",") ;
			if (DEBUG) System.out.println( "args2: " + Arrays.toString(args2) ) ;
			for (int i = 0; i < args2.length; i++) { 		      
	          	String arg = args2[i] ;
	          	String type = arg.trim().split(" ")[0] ;
	          	String name = arg.trim().split(" ")[1] ;
	          	UMLArg theArg = new UMLArg() ;
	          	theArg.name = name ;
	          	theArg.javaType = type ;
	          	theArg.type = parse_type(type) ; 	
	          	this.arguments.add(theArg) ;	
	      	} 			
		}


		// Print JSON 
		if (DEBUG)
			Main.printJSON(this) ;
		
	}

	/**
		Parse Java Types in following format:

			int[] 			=> int(*)
			Collection<B> 	=> B(*)

	**/
	private String parse_type( String _type ) {
		String type = "" ;
		type = _type ;
	    type = type.replace("[","(*") ;
	    type = type.replace("]",")") ;      
	    if ( type.contains("Collection") ) {
	        type = type.replace("Collection<","") ;
	        type = type.replace(">","(*)") ;
	    }  
	    return type ;
	}



}

