
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/

import java.util.Random

val function = fun() {
	println( "Hello" )
}

fun exec( func: () -> Unit ) {
	func()
}

fun fun1 () {
	println( function )
	function()
	exec(function)
}

val random = Random()
val list1 = List( 10, { random.nextInt(100)} ) // lambda as last item in arg list
val list2 = List( 10 ) { random.nextInt(100) } // lambda moved outside of ()'s'

val list = List( 10, { random.nextInt(100)} )
val histogram = list.map {
	(0..it).fold( "" ) { acc, i -> "$acc*" }
}

fun fun2 () {
	println( list1 )
	println( list2 )
	println( list )
	histogram.forEach { println(it) }
}

fun double( vararg value : Int ) : () -> List<Int> {
	return { value.map { it * 2 } }
}

fun fun3() {
	var func = double(1, 2, 3)
	println(func)
	println(func())
}

class FunctionClass( vararg var values : Int) : () -> List<Int> {
	override fun invoke() : List<Int> {
		return values.map { it * 2}
	}
}

fun fun4() {
	val c = FunctionClass( 1, 2, 3, 4, 5 )
	println( c() )
}


// Main 

fun main(args: Array<String>) {

	fun1()
	//fun2()
	//fun3()	
	//fun4()

}
