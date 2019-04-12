
/*

	Kotlin From the Ground Up LiveLessons Video Training - Justin Lee

	https://learning.oreilly.com/videos/kotlin-from-the/9780135263631

*/

import java.io.File
import java.io.IOException

// Main 

fun getConfig() : String? {
	return try {
		File("/tmp/config.json").readText()
	} catch( e: IOException) {
		null
	}
}


fun main(args: Array<String>) {

	try {
		File("/tmp/test").writeText( "hello\n" )
	} catch( e: IOException) {
		e.printStackTrace()
	}

	val config1 = try {
		File("/tmp/config.json").readText()
	} catch( e: IOException) {
		"{}"
	}
	println( config1 )

	val config2 = getConfig() ?: throw Exception( "Config not found")


}
