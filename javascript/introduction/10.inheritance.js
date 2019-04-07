/*
	REF:  

	https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
	https://developer.mozilla.org/en-US/docs/Web/JavaScript/Inheritance_and_the_prototype_chain

	JavaScript is a bit confusing for developers experienced in class-based
	languages (like Java or C++), as it is dynamic and does not provide a
	class implementation per se (the class keyword is introduced in ES2015,
	but is syntactical sugar, JavaScript remains prototype-based).

	When it comes to inheritance, JavaScript only has one construct: objects.
	Each object has a private property (referred to as [[Prototype]] ) which
	holds a link to another object called its prototype. That prototype object
	has a prototype of its own, and so on until an object is reached with null
	as its prototype. By definition, null has no prototype, and acts as the
	final link in this prototype chain.

	Nearly all objects in JavaScript are instances of Object which sits on the
	top of a prototype chain.

	While this is often considered to be one of JavaScript's weaknesses, the
	prototypal inheritance model is in fact more powerful than the classic
	model. It is, for example, fairly trivial to build a classic model on top
	of a prototypal model.

*/


/* ===========================================================================

	Inheritance with the prototype chain
	Inheriting properties

	JavaScript objects are dynamic "bags" of properties (referred to as own
	properties). JavaScript objects have a link to a prototype object. When trying
	to access a property of an object, the property will not only be sought on the
	object but on the prototype of the object, the prototype of the prototype, and
	so on until either a property with a matching name is found or the end of the
	prototype chain is reached.

	Setting a property to an object creates an own property. The only
	exception to the getting and setting behavior rules is when there is an
	inherited property with a getter or a setter.

	// Let's assume we have object o, with its own properties a and b:
	// {a: 1, b: 2}
	// o.[[Prototype]] has properties b and c:
	// {b: 3, c: 4}
	// Finally, o.[[Prototype]].[[Prototype]] is null.
	// This is the end of the prototype chain, as null,
	// by definition, has no [[Prototype]].
	// Thus, the full prototype chain looks like:
	// {a: 1, b: 2} ---> {b: 3, c: 4} ---> null

	console.log(o.a); // 1
	// Is there an 'a' own property on o? Yes, and its value is 1.

	console.log(o.b); // 2
	// Is there a 'b' own property on o? Yes, and its value is 2.
	// The prototype also has a 'b' property, but it's not visited. 
	// This is called "property shadowing."

	console.log(o.c); // 4
	// Is there a 'c' own property on o? No, check its prototype.
	// Is there a 'c' own property on o.[[Prototype]]? Yes, its value is 4.

	console.log(o.d); // undefined
	// Is there a 'd' own property on o? No, check its prototype.
	// Is there a 'd' own property on o.[[Prototype]]? No, check its prototype.
	// o.[[Prototype]].[[Prototype]] is null, stop searching,
	// no property found, return undefined.	

*/

function protos(object) {
	if ( Object.getPrototypeOf(object) == null )
		return
	var proto = object.constructor.prototype,
	    result = 'this';
	while (proto) {
	    result += ' -> ' + proto.constructor.name;
	    proto = Object.getPrototypeOf(proto)
	}
	console.log( result )
}

// Inheriting "methods"
//
// JavaScript does not have "methods" in the form that class-based languages
// define them. In JavaScript, any function can be added to an object in the
// form of a property. An inherited function acts just as any other property,
// including property shadowing as shown above (in this case, a form of method
// overriding).
//
// When an inherited function is executed, the value of this points to the
// inheriting object, not to the prototype object where the function is an own
// property.

var o = {
  a: 2,
  m: function() {
    return this.a + 1;
  }
};

console.log(o.m()); // 3
// When calling o.m in this case, 'this' refers to o

var p = Object.create(o);  // creates object with given prorotype
// p is an object that inherits from o

protos(p)
console.log( p )

p.a = 4; // creates an own property 'a' on p
console.log(p.m()); // 5
// when p.m is called, 'this' refers to p.
// So when p inherits the function m of o, 
// 'this.a' means p.a, the own property 'a' of p


// ==================================================================
// Different ways to create objects and the resulting prototype chain
// ==================================================================


// --------------------------------------
// Objects created with syntax constructs
// --------------------------------------

var o = {a: 1};
console.log( o )
protos(o)

// The newly created object o has Object.prototype as its [[Prototype]]
// o has no own property named 'hasOwnProperty'
// hasOwnProperty is an own property of Object.prototype. 
// So o inherits hasOwnProperty from Object.prototype
// Object.prototype has null as its prototype.
// o ---> Object.prototype ---> null

var b = ['yo', 'whadup', '?'];
console.log( b )
protos( b )

// Arrays inherit from Array.prototype 
// (which has methods indexOf, forEach, etc.)
// The prototype chain looks like:
// b ---> Array.prototype ---> Object.prototype ---> null

function f() {
  return 2;
}
console.log( f )
protos( f )

// Functions inherit from Function.prototype 
// (which has methods call, bind, etc.)
// f ---> Function.prototype ---> Object.prototype ---> null



// -----------------------------------------------------------------------
// With a constructor
// ==================
// A "constructor" in JavaScript is "just" a function
// that happens to be called with the new operator.
// -----------------------------------------------------------------------

function Graph() {
  this.vertices = [];
  this.edges = [];
}

Graph.prototype = {
  addVertex: function(v) {
    this.vertices.push(v);
  }
};

var g = new Graph();
console.log( g )
protos( g )
// g is an object with own properties 'vertices' and 'edges'.
// g.[[Prototype]] is the value of Graph.prototype when new Graph() is executed.


// -------------------------------------------------------------------------
// With Object.create 
// ==================
// ECMAScript 5 introduced a new method: Object.create().
// Calling this method creates a new object. The prototype of this object is
// the first argument of the function:
// -------------------------------------------------------------------------

var a = {a: 1}; 
// a ---> Object.prototype ---> null
console.log( "a => ", a )
protos( a ) 

var b = Object.create(a);
// b ---> a ---> Object.prototype ---> null
console.log(b.a); // 1 (inherited)
console.log( "b => ",b )
protos( b )

var c = Object.create(b);
// c ---> b ---> a ---> Object.prototype ---> null
console.log( "c => ", c )
protos( c )

var d = Object.create(null);
// d ---> null
console.log(d.hasOwnProperty); 
// undefined, because d doesn't inherit from Object.prototype
console.log( "d => ", d )
protos( d )


// -----------------------------------------------------------------------
// With the class keyword
// ======================
// ECMAScript 2015 introduced a new set of keywords implementing classes.
// Although these constructs look like those familiar to developers of class-
// based languages, they are not the same. JavaScript remains prototype-based.
// The new keywords include class, constructor, static, extends, and super.
// -----------------------------------------------------------------------

'use strict';

class Polygon {
  constructor(height, width) {
    this.height = height;
    this.width = width;
  }
}

class Square extends Polygon {
  constructor(sideLength) {
    super(sideLength, sideLength);
  }
  get area() {
    return this.height * this.width;
  }
  set sideLength(newLength) {
    this.height = newLength;
    this.width = newLength;
  }
}

var square = new Square(2);

console.log( "square => ", square )
protos( square )




/*

Performance
===========

	The lookup time for properties that are high up on the prototype chain can
	have a negative impact on performance, and this may be significant in code
	where performance is critical. Additionally, trying to access nonexistent
	properties will always traverse the full prototype chain.

	Also, when iterating over the properties of an object, every enumerable
	property that is on the prototype chain will be enumerated. To check whether
	an object has a property defined on itself and not somewhere on its prototype
	chain, it is necessary to use the hasOwnProperty method which all objects
	inherit from Object.prototype. To give you a concrete example, let's take the
	above graph example code to illustrate it:


	** hasOwnProperty ** is the only thing in JavaScript which deals with properties
	and does not traverse the prototype chain.

	Note: It is not enough to check whether a property is undefined. The
	property might very well exist, but its value just happens to be set to
	undefined.

*/


function Graph() {
  this.vertices = [];
  this.edges = [];
}

Graph.prototype = {
  addVertex: function(v) {
    this.vertices.push(v);
  }
};

var g = new Graph();
console.log( "g => ", g )
protos( g )
console.log( "g's proto => ", g.__proto__ )

console.log("g has verticies: ", g.hasOwnProperty('vertices'));	// true
console.log("g has nope: ", g.hasOwnProperty('nope'));	// false
console.log("g has addVertex: ", g.hasOwnProperty('addVertex'));  // false
console.log("g's proto has addVertex: ", g.__proto__.hasOwnProperty('addVertex'));	// true















