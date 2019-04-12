

/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/


fun fun1() {

	val array = arrayOf(1,2,3)

	for ( x in array ) {
		println(x)
	}

}

fun fun2() {

	val array = arrayOf("A","B","C")
	
	for ( x in array.withIndex() ) {
		println(x)
		println( "${x.index}: ${x.value}" )
	}
}


fun fun3() {

	val list = listOf("A","B","C")
	
	for ( x in list ) {
		println(x)
	}

	for ( x in 0..list.size ) {
		println(x)
	}

}

fun fun4() {
	
	for ( x in 100 downTo 0 ) {
		println(x)
	}

	for ( x in 100 downTo 0 step 5) {
		println(x)
	}

	for ( x in 0..100 step 5 ) {
		println(x)
	}

}


// Main 

fun main(args: Array<String>) {

	fun1()
	fun2()
	fun3()
	fun4()

}