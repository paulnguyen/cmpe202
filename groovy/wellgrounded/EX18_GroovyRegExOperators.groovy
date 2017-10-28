
/*

Groovy Notation & Java equivalent

~	Creates a pattern (creates a compiled Java Pattern object)
=~	Creates a matcher (creates a Java Matcher object)
==~	Evaluates the string (effectively calls Java’s match() on the Pattern)”

REF:

https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
http://groovy-lang.org/operators.html#_regular_expression_operators

ALSO:

http://groovy.jmiguel.eu/groovy.codehaus.org/Tutorial+5+-+Capturing+regex+groups.html

*/

import java.util.regex.*

/* Java Way */

println ( "===  Java   ===" )
Pattern pattern1 = Pattern.compile("1010");
String input1 = "1010";
Matcher matcher1 = pattern1.matcher(input1);
if (input1.matches("1010"))
{
  input = matcher1.replaceFirst("0101");
  System.out.println(input);
}


println ( "=== Groovy ===" )

def pattern2 = /1010/
def input2 = "1010"
def matcher2 = input2 =~ pattern2
if (input2 ==~ pattern2)
{
  input = matcher2.replaceFirst("0101")
  println input
}

("Hazel 1" =~ /(\w+) (\d+)/).each {println it}
("Hazel 1" =~ /(\w+) (\d+)/).each {full, name, age -> println "$name is $age years old."}

