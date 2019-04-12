

/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/


fun fun1() {
	val x = 87
	val msg = when(x) {
		in Int.MIN_VALUE..59 -> "some message"
		else -> "some other message"
	}
	println ( msg )
}

fun fun2() {
	val x = 87
	val msg = when {
		x < 59 -> "some message"
		else -> "some other message"
	}
	println ( msg )
}

fun fun3() {
	//val x : Any = "String"
	val x : Any = 45.toLong()

	when(x) {
		is String -> println( "String" )
		is Int -> println( "Int")
		else ->println( "?" )
	}
}

// Main 

fun main(args: Array<String>) {

	fun1()
	fun2()
	fun3()

}

