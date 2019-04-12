
// http://kotlinlang.org/docs/reference/extensions.html


// Kotlin, similar to C# and Gosu, provides the ability to extend a class with
// new functionality without having to inherit from the class or use any type
// of design pattern such as Decorator. This is done via special declarations
// called extensions. Kotlin supports extension functions and extension
// properties.


fun titleCase( string : String ) : String {
	return string.split( " " )
		.map{ it[0].toUpperCase() + it.substring(1)}
		.joinToString("")
}

fun fun1 () {
	val string = "I am a full sentence."
	println( titleCase(string) )
}

/* ============================ */


fun String.toTitleCase() : String{
	return split( " " )
		.map{ it[0].toUpperCase() + it.substring(1)}
		.joinToString("")	
}

fun fun2 () {
	val string = "I am a full sentence."
	println( string.toTitleCase() )
	println(  "I am a full sentence.".toTitleCase() )
}

/* ============================ */

data class Student(
	val name : String,
	val age : Int
)

data class Class( 
	val students : List<Student>
)

val Class.oldest : Student?
	get() = students.maxBy { it.age  }

fun fun3() {
	val classroom = Class( listOf(
			Student("Jane",12),
			Student("Jimmy", 13),
			Student("Harod", 11)
		))
	println( classroom )
	println( classroom.oldest )
}

/* ============================ */

// Main 

fun main(args: Array<String>) {

	//fun1()
	//fun2()
	fun3()

}

