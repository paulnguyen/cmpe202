
/*

	Groovy Programming Language 

	http://groovy-lang.org/
*/


// Basic Groovy Object Example
// * http://docs.groovy-lang.org/docs/latest/html/documentation/#_class

import java.lang.reflect.* ;

class GumballMachine {
	
	String model  = "M1V192019"
	String serial = "123997919189"
	Integer count = 100
	private Integer coinValue = 0 ; // cents
	private Integer cost = 0 ; // configure at setup	

	static void main(String[] args) {
		GumballMachine m = new GumballMachine()
		println ( "${m.model} ${m.serial} ${m.count}" )
		println ( "** Properties **" )
		m.class.getDeclaredFields().each {
			String modifiers = ""
			if ( Modifier.isPublic(it.modifiers) )		modifiers += " public"
			if ( Modifier.isPrivate(it.modifiers) )		modifiers += " private"
			if ( Modifier.isProtected(it.modifiers) )	modifiers += " protected"
			if ( Modifier.isStatic(it.modifiers) )		modifiers += " static"
			println ( "${modifiers} ${it.name}" )
    	}
        println ( "** Methods **" )
        m.metaClass.getMethods().each { 
            println ( " ${it} " ) 
        }
	}
}


// Groovy Object with Meta Programming
// * http://groovy-lang.org/metaprogramming.html

import java.lang.reflect.* ;
import groovy.json.* ;

class GumballMachine {
	
	String model  = "M1V192019"
	String serial = "123997919189"
	Integer count = 100
	private Integer coinValue = 0 ; // cents
	private Integer cost = 0 ; // configure at setup	

	def printMe() {
		println ( "Model:${this.model} Serial#:${this.serial} Count:${this.count} " + 
				  "Coin Value:${this.coinValue} Cost:${this.cost}" )
	}

	def methodMissing( String name, def args) {
        if ( name == "setCrankModel25" ) {
        	println ( "Crank Model - 25 cents" )
        	this.cost = 25
        }
        else if ( name == "setCrankModel50" ) {
        	println ( "Crank Model - 50 cents" )
        	this.cost = 50
        }    
        else if ( name == "setSlotModel50" ) {
        	println ( "Slot Model - 50 cents" )
        	this.cost = 50
        }                
   	}

	static void main(String[] args) {
		GumballMachine m = new GumballMachine()
		m.printMe()
		println ( new JsonBuilder(m).toPrettyString() )
		m.setCrankModel25()
		m.printMe()
	}
}



// Sample Groovy Design Pattern
// * http://docs.groovy-lang.org/docs/latest/html/documentation/#_design_patterns_in_groovy

class TracingDecorator {
    
    private delegate
    
    TracingDecorator(delegate) {
        this.delegate = delegate
    }

    def invokeMethod(String name, args) {
        println "Calling $name$args"
        def before = System.currentTimeMillis()
        def result = delegate.invokeMethod(name, args)
        println "Got $result in ${System.currentTimeMillis()-before} ms"
        result
    }
}

class Calc {
    def add(a, b) { a + b } 
}

static void main(String[] args) {
	def tracedCalc = new TracingDecorator(new Calc())
	tracedCalc.add(3, 12)
}   








