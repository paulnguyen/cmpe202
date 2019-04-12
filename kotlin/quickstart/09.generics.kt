
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/

class Holder<T> ( var contents : T ) {
	fun unwrap() : T {
		return contents
	}
}


// Main 

fun main(args: Array<String>) {

	var string_holder = Holder( "Hello" )
	var string : String = string_holder.unwrap()
	println( string_holder.contents )
	println( string )

	var int_holder = Holder( 10 )
	var int : Int = int_holder.unwrap()
	println( int_holder.contents )
	println( int )

	var any_holder = Holder( "Goodbye" )
	var any  = any_holder.unwrap()
	println( any_holder.contents )
	println( any )

}
