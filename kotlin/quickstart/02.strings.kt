
// http://kotlinlang.org/docs/reference/basic-types.html#string-literals

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2} ${month} \d{4}"""

// Strings may contain template expressions, i.e. pieces of code that are
// evaluated and whose results are concatenated into the string. A template
// expression starts with a dollar sign ($) and consists of either a simple
// name:

fun fun1() {
	val i = 10
	println("i = $i") // prints "i = 10"
}

// Or an arbitrary expression in curly braces:

fun fun2() {
	val s = "abc"
	println("$s.length is ${s.length}") // prints "abc.length is 3"
}

// Main

fun main() {

	println( "getPattern() ==> " +  getPattern() )
	fun1()
	fun2()

}

