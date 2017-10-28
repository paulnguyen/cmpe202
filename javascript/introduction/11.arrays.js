/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	Arrays in JavaScript are actually a special type of object. They work very
	much like regular objects (numerical properties can naturally be accessed
	only using [] syntax) but they have one magic property called 'length'.
	This is always one more than the highest index in the array.

*/


// One way of creating arrays is as follows:

var a = new Array();
a[0] = 'dog';
a[1] = 'cat';
a[2] = 'hen';
console.log( a )
console.log( a.length ) ; // 3


// A more convenient notation is to use an array literal:
var a = ['dog', 'cat', 'hen'];
console.log( a )
console.log( a.length ) ; // 3

// Note that array.length isn't necessarily the number of items in the array.
// Consider the following:

var a = ['dog', 'cat', 'hen'];
a[100] = 'fox';
console.log( a )
console.log( a.length ) ; // 101

// Remember — the length of the array is one more than the highest index.

// If you query a non-existent array index, you'll get a value of undefined
// returned:

console.log ( typeof a[90] ) ; // undefined


// If you take the above about [] and length into account, you can iterate
// over an array using the following for loop:

for (var i = 0; i < a.length; i++) {
  // Do something with a[i]
}


// ECMAScript introduced the more concise for...of loop for iterable objects
// such as arrays:

for (const currentValue of a) {
  // Do something with currentValue
}

// You could also iterate over an array using a for...in loop. But if someone
// added new properties to Array.prototype, they would also be iterated over
// by this loop. Therefore this loop type is not recommended for arrays.

for (v in a) { 
  console.log( v )
}

// Another way of iterating over an array that was added with ECMAScript 5 is
// forEach():

['dog', 'cat', 'hen'].forEach( 
	function(currentValue, index, array) {
  	// Do something with currentValue or array[index]
  	console.log( currentValue, " - ", array[index] )
  }
 );


// If you want to append an item to an array simply do it like this:

a.push(99);


/*

Arrays come with a number of methods. See also the full documentation for array methods.

REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

Method name 				Description
a.toString() 				Returns a string with the toString() of each element separated by commas.
a.toLocaleString() 			Returns a string with the toLocaleString() of each element separated by commas.

a.concat(item1[, item2[, 
	...[, itemN]]]) 		Returns a new array with the items added on to it.

a.join(sep) 				Converts the array to a string — with values delimited by the sep param
a.pop() 					Removes and returns the last item.
a.push(item1, ..., itemN) 	Appends items to the end of the array.
a.reverse() 				Reverses the array.
a.shift() 					Removes and returns the first item.
a.slice(start[, end]) 		Returns a sub-array.
a.sort([cmpfn]) 			Takes an optional comparison function.

a.splice(start, delcount[, 
	item1[, ...[, itemN]]]) Lets you modify an array by deleting a section and replacing it with more items.

a.unshift(item1[, item2[, 
	...[, itemN]]]) 		Prepends items to the start of the array.

*/


