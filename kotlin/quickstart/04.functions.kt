
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/


// In Kotlin, Functions can be anywhere (i.e. doesn't need a class)

fun foo1( str : String) {
	println( "foo1: $str" )
}

// Default Parameters

fun foo2( str : String = "hello") {
	println( "foo2: $str" )
}

// Default Parameters  / Note: default return type is "Unit"

fun foo3( str : String = "hello", count : Int ) {
	println( "foo3: $str, $count" )
}

// Return type is "Unit"  (like "Void" in Java)

fun foo4( str : String = "hello", count : Int ) : Unit {
	println( "foo4: $str, $count" )
}

// Function Expression (i.e.not Function Body)

fun foo5( str : String = "hello", count : Int ) : String =  "foo5: $str, $count" 

// Return type is "Unit"  (like "Void" in Java)

fun foo6( str : String = "hello", count : Int ) : Unit {
	// inner function
	fun inner_foo() {
		println( "I'm inside of foo6")
	}
	inner_foo()
	println( "foo6: $str, $count" )
}

// Main 

fun main(args: Array<String>) {

	foo1( "bar" )
	foo2( "bar" )
	foo2()
	foo3( "hello", 10 )		// paramter sequence
	foo3( count = 10 )		// named parameters
	foo3( count = 10, str = "hello" )	// named parameters out of order
	foo4( count = 10, str = "hello" )	// named parameters out of order
	println (foo5( count = 10, str = "hello" ))	// named parameters out of order
	foo6( count = 10, str = "hello" )	// named parameters out of order
	//inner_foo() // can't call inner function

}



