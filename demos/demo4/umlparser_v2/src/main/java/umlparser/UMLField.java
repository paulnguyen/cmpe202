/* (c) Copyright 2020 Paul Nguyen. All Rights Reserved */

package umlparser ;

class UMLField {

	private static boolean DEBUG = true ;

	public String name ;
	public String type ;
	public String type_class ;
	public String[] modifiers ;
	public String visibility ;
	public String multiplicity ;
	public String javaType ;
	public String javaVariable ;
	public boolean isClassVariable ;
	public boolean hasType ;

	/**
		Parse Modifier Spec in following format:

			private => -
			public	=> +
			protected => #
			static 	=> class var = true

	**/
	public void parse_modifiers( String _modifiers ) {
		
		String m1 = _modifiers ;
		m1 = m1.replace("[", "") ;
		m1 = m1.replace("]", "") ;
		this.modifiers = m1.trim().split(",") ;
		this.visibility = " " ; 
		this.isClassVariable = false ;

		for ( int i = 0; i < this.modifiers.length; i++ ) {
			this.modifiers[i] = this.modifiers[i].trim() ;
			String modifier = modifiers[i] ;
	        if ( modifier.equals("private") )
	            this.visibility = "-" ;
	        else if ( modifier.equals("public") ) 
	            this.visibility = "+" ;      
	        else if ( modifier.equals("protected") )
	        	this.visibility = "#" ;   
	        else if ( modifier.equals("static") ) {
	        	this.isClassVariable = true ;
	        }
		}

		if (DEBUG)
			Main.printJSON( this ) ;
	}

	/**
		Parse Java Types in following format:

			int[] 			=> int(*)
			Collection<B> 	=> B(*)

	**/
	public void parse_type( String _type ) {
		this.hasType = true ;
		this.javaType = _type ;
		this.type = _type ;
	    this.type = this.type.replace("[","(*") ;
	    this.type = this.type.replace("]",")") ;      
	    if ( this.type.contains("Collection") ) {
	        this.type = this.type.replace("Collection<","") ;
	        this.type = this.type.replace(">","(*)") ;
	    }  
	    if ( this.type.contains("*") )
	    	this.multiplicity = "*" ;
	    else
	    	this.multiplicity = "1" ;
	    this.type_class = this.type ;
	    this.type_class = this.type_class.replace("(","") ;
	    this.type_class = this.type_class.replace(")","") ;
	    this.type_class = this.type_class.replace("*","") ;
	}


	/**
		Parse Variable expression (strip initializers)
	**/
	public void parse_variable( String _variable ) {
		String var = _variable ;
		var = var.replace("[", "") ;
		var = var.replace("]", "") ;	
		var = var.trim() ;	
		this.javaVariable = var ;
		this.name = var.trim().split("=")[0].trim() ;
	}


}