
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/


// typical if-else

fun fun1 () {

	val x = 42

	if ( x < 42 ) {
		println ( "A" )
	} else {
		println ( "B" )
	}

}


// if statement is an expression in kotlin
// (i.e. can return a value)

fun fun2 () {

	val x = 42

	val msg1 = if ( x < 42 ) {
		"A"
	} else {
		"B"
	}

	println ( msg1 )

	// or

	val msg2 = if ( x < 42 ) "A" else "B"

	println ( msg2 )

}



// Main 

fun main(args: Array<String>) {

	fun1()
	fun2()
}
