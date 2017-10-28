/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	JavaScript objects can be thought of as simple collections of name-value
	pairs. As such, they are similar to:

	    Dictionaries in Python.
	    Hashes in Perl and Ruby.
	    Hash tables in C and C++.
	    HashMaps in Java.
	    Associative arrays in PHP.

	The fact that this data structure is so widely used is a testament to its
	versatility. Since everything (bar core types) in JavaScript is an object,
	any JavaScript program naturally involves a great deal of hash table
	lookups. It's a good thing they're so fast!

	The "name" part is a JavaScript string, while the value can be any
	JavaScript value — including more objects. This allows you to build data
	structures of arbitrary complexity.

*/



// There are two basic ways to create an empty object:

var obj1 = new Object();
var obj2 = {};


// These are semantically equivalent; the second is called object literal
// syntax, and is more convenient. This syntax is also the core of JSON format
// and should be preferred at all times.


// Object literal syntax can be used to initialize an object in its entirety:

var obj3 = {
  name: 'Carrot',
  customer: 'Max', 
  details: {
    color: 'orange',
    size: 12
  }
};

// Attribute access can be chained together:

console.log( obj3.details.color ) ; // orange
console.log( obj3['details']['size'] ) ; // 12


// The following example creates an object prototype, Person and an instance
// of that prototype, You.

function Person(name, age) {
  this.name = name;
  this.age = age;
}

// Define an object

var you = new Person('You', 24); 
console.log( you )

// We are creating a new person named "You" aged 24.  Once created, an
// object's properties can again be accessed in one of two ways:

var obj = {}

// dot notation
obj.name = 'Simon';
var name = you.name;

// bracket notation

obj['name'] = 'Simon';
var name = obj['name'];

// can use a variable to define a key

var k = "key"
obj[k] = "value"

console.log( obj )


// These are also semantically equivalent. The second method has the advantage
// that the name of the property is provided as a string, which means it can
// be calculated at run-time. However, using this method prevents some
// JavaScript engine and minifier optimizations being applied. It can also be
// used to set and get properties with names that are reserved words:

obj.for = 'Simon'; // Syntax error, because 'for' is a reserved word
obj['for'] = 'Simon'; // works fine


/* 

	NOTE:

	Starting in ECMAScript 5, reserved words may be used as object property names
	"in the buff". This means that they don't need to be "clothed" in quotes when
	defining object literals. See the ES5 Spec.

	Starting in ECMAScript 2015, object keys can be defined by variable using
	bracket notation upon being created. {[phoneType]: 12345} is possible
	instead of just var userPhone = {}; userPhone[phoneType] = 12345.

*/























