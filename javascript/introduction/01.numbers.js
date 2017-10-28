/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
*/

/* 

	Numbers in JavaScript are "double-precision 64-bit 
	format IEEE 754 values", according to the spec.
	In practice, integer values are treated as 32-bit 
	ints, and some implementations even store it that 
	way until they are asked to perform an instruction 
	that's valid on a Number but not on a 32-bit integer. 
	This can be important for bit-wise operations.

*/

console.log ( "0.1 + 0.2 = ", 0.1 + 0.2)
console.log ( "1 + 0.2 = ", 1 + 0.2)
console.log ( "1.0 + 2 = ", 1.0 + 2)

/*

	The standard arithmetic operators are supported, including 
	addition, subtraction, modulus (or remainder) arithmetic,
	and so forth. There's also a built-in object that we forgot 
	to mention earlier called Math that provides advanced 
	mathematical functions and constants:

*/

console.log ( "Math.sin(3.5) = ", Math.sin(3.5) );
var r = 2;
var circumference = 2 * Math.PI * r;
console.log( "circumference:", circumference ) ;

/*

	You can convert a string to an integer using the built-in parseInt()
	function. This takes the base for the conversion as an optional second
	argument, which you should always provide:

*/


console.log( "parseInt('123', 10) = ", parseInt('123', 10) ); // 123
console.log( "parseInt('010', 10) = ", parseInt('010', 10) ); // 10
console.log( "parseInt('010') = ", parseInt('010') );  //  8
console.log( "parseInt('0x10') = ", parseInt('0x10') ); // 16
console.log( "parseInt('11', 2) = ", parseInt('11', 2) ); // 3

/*

	Similarly, you can parse floating point numbers using the built-in
	parseFloat() function. Unlike its parseInt() cousin, parseFloat() always
	uses base 10.

	You can also use the unary + operator to convert values to numbers:

*/

console.log( "parseFloat('3.14159') = ", parseFloat('3.14159') ) ;
console.log( "+ '42' = ", + '42' );   // 42
console.log( "+ '010' = ", + '010' );  // 10
console.log( "+ '0x10' = ", + '0x10' ); // 16

/*

	The parseInt() and parseFloat() functions parse a string until
	they reach a character that isn't valid for the specified number
	format, then return the number parsed up to that point. However
	the "+" operator simply converts the string to NaN if there is an
	invalid character contained within it. Just try parsing the string
	"10.2abc" with each method by yourself in the console and you'll
	understand the differences better.

*/

console.log( "parseInt('10abc') = ", parseInt('10abc') ) ;
console.log( "+ '10abc' = ", + '10abc' ) ;


/*

	A special value called NaN (short for "Not a Number") is returned 
	if the string is non-numeric:

*/

console.log( "parseInt('hello', 10) = ", parseInt('hello', 10) ); // NaN


/*

	NaN is toxic: if you provide it as an input to any mathematical 
	operation the result will also be NaN:

*/

console.log( "NaN + 5 = ", NaN + 5 ) ; // NaN


/*

	You can test for NaN using the built-in isNaN() function:

*/

console.log( "isNaN(NaN) =", isNaN(NaN) ); // true

/*

	JavaScript also has the special values Infinity and -Infinity:

*/

console.log( "1 / 0 = ", 1 / 0 ); //  Infinity
console.log( "-1 / 0 = ", -1 / 0 ); // -Infinity
