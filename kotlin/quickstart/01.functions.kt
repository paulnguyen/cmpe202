
// https://kotlinlang.org/docs/reference/basic-syntax.html

fun start(): String = "OK"

// https://kotlinlang.org/docs/reference/functions.html#default-arguments
// https://kotlinlang.org/docs/reference/collections.html

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)

// https://kotlinlang.org/docs/reference/lambdas.html

fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }


// Main

fun main() {
	println( "start() ==> " +  start() )
	println( "joinOptions(listOf( \"A\", \"B\", \"C\") ) ==> " + joinOptions(listOf( "A", "B", "C")) )
	println( "useFoo() ==> " + useFoo() )
	println( "containsEven(listOf(1,2,3,4)) ==> " + containsEven(listOf(1,2,3,4)) )
	println( "containsEven(listOf(3,5,7,9)) ==> " + containsEven(listOf(3,5,7,9)) )
}

