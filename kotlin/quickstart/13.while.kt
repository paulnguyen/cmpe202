
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/



fun fun1 () {
	var x = 100
	while ( x >= 0 ) {
		println( x )
		x -= 5
	}

}

fun fun2 () {
	val x = 50
	val msg = if (x < 60) "Hello!" else return
	println ( msg )
}

fun fun3 () : String {
	val x = 70
	return if (x < 60) "Hello!" else "Goodbye!"
}

// Main 

fun main(args: Array<String>) {

	fun1()
	println ( fun2() )
	println ( fun3() )
}
