/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
*/


/*

	JavaScript distinguishes between null, which is a value that indicates a
	deliberate non-value (and is only accessible through the null keyword), and
	undefined, which is a value of type undefined that indicates an uninitialized
	value — that is, a value hasn't even been assigned yet. We'll talk about
	variables later, but in JavaScript it is possible to declare a variable
	without assigning a value to it. If you do this, the variable's type is
	undefined. undefined is actually a constant.

*/


var testvar
var nullvar = null
console.log( "testvar = ", testvar )
console.log( "nullvar = ", nullvar )


/*     

	JavaScript has a boolean type, with possible values true and false
	(both of which are keywords.) Any value can be converted to a boolean
	according to the following rules:

    1. False Values:

    	false, 
    	0, 
    	empty strings (""), 
    	NaN, 
    	null, 
    	and undefined all become false.

    2. All other values become true.

	You can perform this conversion explicitly using the Boolean() function:

*/

console.log( "Boolean('') = ", Boolean('') ) ;  // false
console.log( "Boolean(234) = ", Boolean(234) ) ; // true


/*

	However, this is rarely necessary, as JavaScript will silently perform
	this conversion when it expects a boolean, such as in an if statement (see
	below). For this reason, we sometimes speak simply of "true values" and
	"false values," meaning values that become true and false, respectively,
	when converted to booleans. Alternatively, such values can be called
	"truthy" and "falsy", respectively.

	Boolean operations such as && (logical and), || (logical or), and !
	(logical not) are supported;

*/


if ( Boolean(234) )
	console.log( "Truthy")

if ( !null )
	console.log( "Falsy")

if ( !nullvar )
	console.log( "Falsy")

if ( !nullvar && !testvar )
	console.log( "Falsy")



