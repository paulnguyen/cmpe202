
/*

1.  Groovy treats == as the equivalent of the equals() method in Java.
2.	To Check for object identity equality, use Groovy’s built-in is() 
3. 	Can use == when checking to see if an object is null

*/

Integer x = new Integer(2)
Integer y = new Integer(2)
Integer z = null

println "Integer x = new Integer(2)"
println "Integer y = new Integer(2)"
println "Integer z = null"

if (x == y)  		{ println "x == y" }
if (x.equals(y))  	{ println "x equals y" }
if (!x.is(y))		{ println "x is not y" }
if (z.is(null))		{ println "z is null" }
if (z == null)		{ println "z is null" }