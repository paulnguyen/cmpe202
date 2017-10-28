/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
*/


/*

	Strings in JavaScript are sequences of Unicode characters. This should
	be welcome news to anyone who has had to deal with
	internationalization. More accurately, they are sequences of UTF-16
	code units; each code unit is represented by a 16-bit number. Each
	Unicode character is represented by either 1 or 2 code units.

*/


// To find the length of a string (in code units), access its length property:

console.log( "'hello'.length = ", 'hello'.length ) ; // 5

/*

	There's our first brush with JavaScript objects! Did we mention that
	you can use strings like objects too? They have methods as well that
	allow you to manipulate the string and access information about the
	string:

*/

console.log( "'hello'.charAt(0) = ", 'hello'.charAt(0) ); // "h"
console.log( "'hello, world'.replace('hello', 'goodbye') = ", 'hello, world'.replace('hello', 'goodbye') ); // "goodbye, world"
console.log( "'hello'.toUpperCase() = ", 'hello'.toUpperCase() ); // "HELLO"




