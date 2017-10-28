
/*

Default Groovy Imports:

groovy.lang.*
groovy.util.*
java.lang.*
java.io.*
java.math.BigDecimal
java.math.BigInteger
java.net.*
java.util.*
java.math.*


Groovy is "Java", but these are "optional":

1. Semicolons at the end of a statement
2. return statements
3. Parentheses for method parameters
4. public access modifiers


Groovy Enhancements to Java/JDK 7

1. Groovy Beans
2. Safe navigation of null objects (?. operator)
3. shorter if/else (elvis operator)
4. Function Literals (Lambda/Closures)
5. Native Support for Regular Expressions
6. XML/JSON Handling


Groovy Style Guide:

http://groovy-lang.org/style-guide.html

*/



/* 

Sublime 3 Setup:

/Users/pnguyen/Library/Application Support/Sublime Text 3/Packages/User

Run groovy script from sublime text 3 Tools -> Build System -> New Build System, Paste below and save as groovy.sublime-build

groovy.sublime.-build
{
	"cmd": ["groovy","$file"],
	"selector": "source.groovy",
	"file_regex": "[ ]*at .+[(](.+):([0-9]+)[)]",
}

*/


