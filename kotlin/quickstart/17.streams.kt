/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/

fun display( any : Any ) {

	println( "value: $any")
	println( "type:  ${any::class.java}")

}


fun fun1() {

	val list = (0..10).toList()
	println( list )
	println( list.filter { it % 2 == 0 } )


}

fun fun2() {

	val list = (0..10).toList()
	val updated = list.filter { it % 2 == 0 } 
					.map { it * 2  }
	println( list )
	println( updated )

}


fun fun3() {

	val list = (0..10).toList()

	val oddOrEven1 = list
					.groupBy { it % 2 == 0 } 
					.map { (k, v) -> (if (k) "even" else "odd") to v  }
					.toMap()
	println( oddOrEven1 )

	val oddOrEven2 = list
					.groupBy { it % 2 == 0 } 
					.mapKeys { (k, v) -> if (k) "even" else "odd" }
	println( oddOrEven2 )
}



fun fun4() {

	val list = (0..10).toList()

	println( list )
	println( list.any { it % 7 == 0 } ) // prints "true" if at lease one element found
	println( list.all { it % 7 == 0 } ) // prints "true" if all elements match
	println( list
				.filter { it % 7 == 0 }
				.all { it % 7 == 0 } ) // prints "true" if all elements match

}



fun main(args: Array<String>) {

	//fun1()
	// fun2()
	//fun3()
	fun4()
}