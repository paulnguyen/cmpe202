/*

GroovyBeans are much like JavaBeans, except they omit the explicit 
getters and setters, provide auto constructors, and allow you to 
reference member variables using dot (.) notation.

*/


import groovy.transform.Immutable


class Character
{
	private int strength
	private int wisdom
}

def pc = new Character(strength: 10, wisdom: 15)
pc.strength = 18
println "STR [${pc.strength}]  WIS [${pc.wisdom}]"


/*  REF:  http://docs.groovy-lang.org/next/html/gapi/groovy/transform/Immutable.html */

@Immutable class Customer {
     String first, last
     int age
     Date since
     Collection favItems
 }

def d = new Date()
def c1 = new Customer(first:'Tom', last:'Jones', age:21, since:d, favItems:['Books', 'Games'])
def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])

println c1 == c2
c1.age = 100
