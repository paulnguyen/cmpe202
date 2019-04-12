/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/

fun display( any : Any ) {

	println( "value: $any")
	println( "type:  ${any::class.java}")

}


fun fun1() {

	val list1 = listOf(1,2,3)
	println( list1 )
	//list1.add(4) // not allowed for imutable list

	val list2 = mutableListOf(1,2,3)
	list2.add(4)
	println( list2 )

	val map1 = mapOf( "one" to 1, "two" to 2, "three" to 3)
	println( map1 )
	//map1.put("three", 3) // not allowed for imutable map

	val map2 = mutableMapOf( "one" to 1, "two" to 2, "three" to 3)
	map2.put("four", 4)
	println( map2 )	

}

fun fun2() {

	display( listOf(1,2,3) )	
	display( mutableListOf(1,2,3) )

	display( mapOf( "one" to 1, "two" to 2, "three" to 3) )
	display( mutableMapOf( "one" to 1, "two" to 2, "three" to 3) )
	display( sortedMapOf( "one" to 1, "two" to 2, "three" to 3) )
	display( hashMapOf( "one" to 1, "two" to 2, "three" to 3) )

	display( setOf( 1, 2, 3 ) )
	display( mutableSetOf(  1, 2, 3 ) )
	display( sortedSetOf(  1, 2, 3 ) )
	display( hashSetOf(  1, 2, 3 ) )

}

fun fun3() {

	val list = mutableListOf( 1, 2, 3 ) // val is required to use operator overloads
	//var list = mutableListOf( 1, 2, 3 ) // var will not work as reference / type may change

	list += 123
	println( list )
	list -= 3
	println( list )
	list.removeAt( 1 )
	println( list )
	println( list[0] )

}


fun fun4() {

	val map = mutableMapOf( "one" to 1, "two" to 2, "three" to 3)
	map += "four" to 4
	println( map )
	map -= "three"
	println( map )
	println( map.get("two") )
	println( map["two"] )

}


fun fun5() {

	val set = mutableSetOf(  1, 2, 3, 3, 3 )
	println( set )
	set += 2
	set += 4
	println( set )
	set -= 4
	println( set )
	set -= 4
	println( set )
	// note index operation [] not defined for sets

}


fun main(args: Array<String>) {

	//fun1()
	//fun2()
	//fun3()
	//fun4()
	fun5()
}