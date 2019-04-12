
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/



fun fun1 () {
	for ( i in 0..100 ) {
		for ( j in 1..10 ) {
			if ( j%5 == 0 ) continue
			println( j )
		}
	}
}

fun fun2 () {
	loop@ for ( i in 0..100 ) {
		for ( j in 1..100 ) {
			if ( j%5 == 0 ) break@loop
			println( j )
		}
	}
}

fun fun3 () {
	for ( i in 0..100 ) {
	loop@ for ( j in 1..100 ) {
			if ( j%5 == 0 ) break@loop
			println( j )
		}
	}
}

// Main 

fun main(args: Array<String>) {

	fun1()
	fun2()
	fun3()

}
