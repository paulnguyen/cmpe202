

/*

  Kotlin Programming Language 

  https://kotlinlang.org/
  https://play.kotlinlang.org/byExample/overview

*/


// Properties
// http://kotlinlang.org/docs/reference/properties.html

// Variable Property
var count = 10
	get()	= field * 2
	set(value) {
		if ( value < 0)
			println( "Can't set value < 0!")
		else
			field = value
	}

// Constant Property
val name = "Uncle Bob"
	get() = "Hello " + field
	//set(value)  = value // not allowed

// Not nullable, but must set the value before use
lateinit var title : String 

fun properties() {
	println( "** Properties **" )
	println( "Count: $count" )
	println( "Name: $name" )
	count = 100
	println( "Count: $count" )
	title = "Kings Plays Chess..."
	println( "Title: $title" )
}


// Classes
// http://kotlinlang.org/docs/reference/classes.html


class A1 {
	fun foo() {
		println( "A1" )
	}
}

interface B {
	fun foo() {
		println( "B" ) // default implementation
	}
}

// compile error classes closed by default in Kotlin
// class C1: A1() {	
// 	override fun foo() {
// 	}	
// }


// must declare if class can be extended
open class A2 {
	open fun foo() {
		println( "A2" )
	}
}

class C2: A2(), B {
	// foo() must be open in base class
	override fun foo() {

		// two foo's.  from A2 and B
		//super.foo()

		// two foo's.  Select A2's or B's super() 
		// or both!
		super<A2>.foo()
		super<B>.foo()

		println( "C2" )
	}
}

fun classes() {
	println( "** Classes **" )
	C2().foo() ;
}


/*

public class JavaPerson {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
}

*/

// Kotlin Data Class
// https://kotlinlang.org/docs/reference/data-classes.html

data class Person (	
	val name: String, 
	val age: Int
)

fun getPeople(): List<Person> {
    return listOf(	Person("Alice", 29), 
    				Person("Bob", 31)
    			 )
}

fun data_class() {
	println( "** Data Class **" )
	println( getPeople() )
}



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

fun interfaces() {

	println( "** Interfaces **" )
	val c = Concrete()
	c.foo()
	c.bar()

}



/*

Higher-Order Functions

A higher-order function is a function that takes another function as parameter
and/or returns a function.

REF:  https://play.kotlinlang.org/byExample/04_functional/01_Higher-Order%20Functions

*/


// Taking Functions as Parameters


// Declares a higher-order function. It takes two integer parameters, x and y.
// Additionally, it takes another function operation as a parameter. The
// operation parameters and return type are also defined in the declaration.

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
	return operation(x, y)  // The higher order function returns the result of
							// operation invocation with the supplied agruments. 
}

// Declares a function that matches the operationsignature.
fun sum(x: Int, y: Int) = x + y                                     

fun lambdas() {

	println( "** Lambdas / Higher Order **" )

	// Invokes the higher-order function passing in two integer values and the
	// function argument ::sum. :: is the notation that references a function by
	// name in Kotlin.
    val sumResult = calculate(4, 5, ::sum)                    

    // Invokes the higher-order function passing in a lambda as a function
    // argument. Looks clearer, doesn't it?
    val mulResult = calculate(4, 5) { a, b -> a * b }               

    println("sumResult $sumResult, mulResult $mulResult")
}





/*

Extension Functions and Properties 

Kotlin lets you add new members to any class with the extensions mechanism.
Namely, there are two types of extensions: extension functions and extension
properties. They look a lot like normal functions and properties but with one
important difference: you need to specify the type that you extend.

REF:  https://play.kotlinlang.org/byExample/04_functional/03_extensionFunctions

*/


// Defines simple models of Item and Order. Order can contain a collection of Item objects.
data class Item(val name: String, val price: Float)                                   
data class Order(val items: Collection<Item>)  

// Adds extension functions for the Order type.
fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F    
fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"

// Adds an extension property for the Order type.
val Order.commaDelimitedItemNames: String                                             
    get() = items.map { it.name }.joinToString()


fun extensions() {

	println( "** Extension Functions **" )

    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))
    
    // Calls extension functions directly on an instance of Order.
    println("Max priced item name: ${order.maxPricedItemName()}")                     
    println("Max priced item value: ${order.maxPricedItemValue()}")

    // Accesses the extension property on an instance of Order.
    println("Items: ${order.commaDelimitedItemNames}")                                

}





/*** ========================== ***/



// Main

fun main() {

	properties()
	classes()
	data_class()
	interfaces()
	lambdas() 
	extensions()

}






