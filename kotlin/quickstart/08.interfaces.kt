

// Kotlin interfaces can have default method, so long as there is no state
//
// Can also extends (like in Java)
// interface Base: Runable 
// 
// Java 8 also has deffault methods
// ref:  https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

interface Base {

	val property : String   // can't do this in Java

	fun foo() {
		println ( "foo: $property" )
	}

	fun bar()
}

class Concrete : Base {

	// required to implement property
	// override val property : String
	// get() = TODO( "Todo: implement property get")

	// or just set a value
	override val property : String = "some value"

	// required to implement bar()
	override fun bar() {
		println( "bar: $property" )
	}

	// foo() has default implementation
	override fun foo() {
		println( "In Concrete!")
		super.foo()
	}
}

// Main 

fun main(args: Array<String>) {

	val c = Concrete()
	c.foo()
	c.bar()

}


