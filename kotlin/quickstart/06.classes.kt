

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

// Main

fun main() {

	properties()
	classes()
	data_class()

}

