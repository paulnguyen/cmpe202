/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	JavaScript's numeric operators are +, -, *, / and % which is the remainder
	operator (which is not the same as modulo.) Values are assigned using =,
	and there are also compound assignment statements such as += and -=. These
	extend out to x = x operator y.

*/


// You can use ++ and -- to increment and decrement respectively. These can be
// used as prefix or postfix operators.

var x = 0
console.log( x += 5 ) ;
console.log( x = x + 5 ) ;


// The + operator also does string concatenation:

console.log( 'hello' + ' world' ) ; // "hello world"

// If you add a string to a number (or other value) everything is converted in
// to a string first. This might catch you up:

console.log( '3' + 4 + 5 ) ;  			// "345"
console.log( 3 + 4 + '5' ) ; 			// "75"
console.log( 3 + 4 + Number('5') ) ; 	// 12
var x = "5"
console.log( 3 + 4 + x ) ; 				// 75
console.log( 3 + 4 + Number(x) ) ; 		// 12

 // Adding an empty string to something is a useful way of converting it to a string itself.


/*

	Comparisons in JavaScript can be made using <, >, <= and >=. These work
	for both strings and numbers. Equality is a little less straightforward.
	The double-equals operator performs type coercion if you give it different
	types, with sometimes interesting results:

*/

console.log( "23 == '123' --> ", 123 == '123' ) ; 	// true
console.log( "1 == true   --> ", 1 == true ) ; 		// true

// To avoid type coercion, use the triple-equals operator:

console.log( "123 === '123' --> ", 123 === '123' ) ; // false
console.log( "1 === true    --> ", 1 === true ) ;    // false


// There are also != and !== operators. JavaScript also has bitwise
// operations. If you want to use them, they're there.
