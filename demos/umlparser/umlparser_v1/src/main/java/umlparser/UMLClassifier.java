/* (c) Copyright 2020 Paul Nguyen. All Rights Reserved */

package umlparser ;

import java.util.*; 

class UMLClassifier {

	private static boolean DEBUG = false ;  

	public String name ;
	public String type ; // "class" or "interface"

	public String extendsClass ;
	public String implementsInterfaces ;

	public boolean hasExtends = false ;
	public boolean hasImplements = false ;

	public HashMap<String, UMLField> attributes = new HashMap<String, UMLField>();
	public List<UMLField> variables = new ArrayList<UMLField>() ;
	public List<UMLMethod> operators = new ArrayList<UMLMethod>() ; 	

	/**
	
		Parse Class Extends and Implements Lists in following format:
		(For Example)

			* Extends:    [P]
   			* Implements: [A1, A2]

	**/
	public void parse(String _exts, String _impl) {
		String exts = _exts ;
		String impl = _impl ;
		
	    exts = exts.replace("[", "") ;
	    exts = exts.replace("]", "") ;
	    exts = exts.trim() ;
	    if (exts.length() > 0) {
	        this.hasExtends = true ;
	        this.extendsClass = exts ;
	        if (DEBUG) 
	            System.out.println( "EXTS: " + exts ) ;
	    }

	    impl = impl.replace("[", "") ;
	    impl = impl.replace("]", "") ;
	    impl = impl.trim() ;
	    if (impl.length() > 0) {
	        this.hasImplements = true ;
	        this.implementsInterfaces = impl ;
	        if (DEBUG) 
	            System.out.println( "IMPL: " + impl ) ;
	    }
	}

}