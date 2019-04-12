

/*

REF:  https://kotlinlang.org/docs/reference/basic-types.html

*/


fun main(args: Array<String>) {

	// Any and Nothing
	var v1 : Any = 0
	var v2 : Nothing 

	println( "v1: $v1" )

	// Java Void = Kotlin Unit
	fun do_nothing() : Unit { }

	// No Primitive Types
	var obj1 : Boolean = true 
	var obj2 : Byte = 1
	var obj3 : Char = 'A'
	var obj4 : CharArray = charArrayOf('A','B','C')
	var obj5 : String = "Hello World"
	var obj6 : Double = 123.5e10
	var obj7 : Float = 123.5f
	var obj8 : Int = 123
	var obj9 : Long = 123L

	println( "$obj1, $obj2, $obj3, $obj4, $obj5, $obj6, $obj7, $obj8, $obj9" )

	// Can Use Underscores in Numeric Literals
	val oneMillion = 1_000_000
	val creditCardNumber = 1234_5678_9012_3456L
	val socialSecurityNumber = 999_99_9999L
	val hexBytes = 0xFF_EC_DE_5E
	val bytes = 0b11010010_01101001_10010100_10010010

	println( "$oneMillion, $creditCardNumber, $socialSecurityNumber, $hexBytes, $bytes" )

	// Explicit Casts Required
	val x = 42
	//val l1 : Long = x // not allowed
	var l2 : Long = x.toLong()

    println( "$x, $l2" )

    // In Java, Arrays are special features of Language
	// In Kotlin, Arrays are Objects

	val array1 : Array<Int> = arrayOf( 1, 2, 3 )
	val array2 : Array<Any> = arrayOf( 1L, 2.toDouble(), "3" )

    array1.forEach() { it -> println ( "$it" ) }
    array2.forEach() { it -> println ( "$it" ) }


}

