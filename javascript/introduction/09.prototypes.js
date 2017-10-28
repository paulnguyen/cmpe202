/*
	REF:  

	https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
	https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/prototype
	https://www.w3schools.com/js/js_object_prototypes.asp

*/

/* 

	Object.prototype:

	Nearly all objects in JavaScript are instances of Object; a typical object
	inherits properties (including methods) from Object.prototype, although
	these properties may be shadowed (a.k.a. overridden). However, an Object
	may be deliberately created for which this is not true (e.g. by
	Object.create(null)), or it may be altered so that this is no longer true
	(e.g. with Object.setPrototypeOf).

	Changes to the Object prototype object are seen by all objects through
	prototype chaining, unless the properties and methods subject to those
	changes are overridden further along the prototype chain.  This provides a
	very powerful although potentially dangerous mechanism to override or
	extend object behavior.

*/


// -----------------------------------------------------
// https://www.w3schools.com/js/js_object_prototypes.asp
// -----------------------------------------------------

/*

	JavaScript Prototypes
	=====================
	
	Every JavaScript object has a prototype. 
	The prototype is also an object.

	All JavaScript objects inherit their properties and methods from their
	prototype.

	All JavaScript objects inherit the properties and methods from their
	prototype.

	Objects created using an object literal, or with new Object(), inherit
	from a prototype called Object.prototype.

	Objects created with new Date() inherit the Date.prototype.
	The Object.prototype is on the top of the prototype chain.
	All JavaScript objects (Date, Array, RegExp, Function, ....) 
	inherit from the Object.prototype.
	
*/


function protos(object) {
	var proto = object.constructor.prototype,
	    result = 'this';
	while (proto) {
	    result += ' -> ' + proto.constructor.name;
	    proto = Object.getPrototypeOf(proto)
	}
	console.log( result )
}

// Creating a Prototype:  The standard way to create an object prototype is to
// use an object constructor function:

function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
}

// With a constructor function, you can use the new keyword to create new
// objects from the same prototype:

var myFather = new Person("John", "Doe", 50, "blue");
var myMother = new Person("Sally", "Rally", 48, "green");

console.log( myFather )
protos( myFather )


// Adding Properties and Methods to Objects: 
//
// 1. Sometimes you want to add new properties (or methods) to an existing object. 
// 2. Sometimes you want to add new properties (or methods) to all existing objects of a given type.
// 3. Sometimes you want to add new properties (or methods) to an object prototype.


// Adding a new property to an existing object is easy:  
// The property will be added to myFather. Not to myMother. Not to any other
// person objects.

myFather.nationality = "English";
console.log( "My Father: ", myFather )


// Adding a new method to an existing object is also easy: 
// The method will be added to myFather. Not to myMother.

myFather.name = function () {
    return this.firstName + " " + this.lastName;
};
console.log( "My Father: ", myFather )


// You cannot add a new property to a prototype the same way as you add a new
// property to an existing object, because the prototype is not an existing
// object.

Person.nationality="English";
console.log( "My Mother: ", myMother )
console.log( "My Mother's Nationality : ", myMother.nationality )


// To add a new property to a prototype, you must add it to the constructor function:

function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
    this.nationality = "English";
}

// Your constructor function can also define methods:

function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;
    this.name = function() {return this.firstName + " " + this.lastName;};
}


// The JavaScript prototype property allows you to add new properties to an
// existing prototype:

Person.prototype.nationality = "English";

var myFather = new Person("John", "Doe", 50, "blue");
var myMother = new Person("Sally", "Rally", 48, "green");

console.log( "My Father's Nationality: ", myFather.nationality )
console.log( "My Mother's Nationality: ", myMother.nationality )


// The JavaScript prototype property also allows you to add new methods to an
// existing prototype:

Person.prototype.fullname = function() {
    return this.firstName + " " + this.lastName;
};

console.log( "My Mother's Name: ", myMother["name"]() )
console.log( "My Mother's Full Name: ", myMother.fullname() )


/* 

	WARNING! -- Only modify your own prototypes. Never modify the prototypes
	of standard JavaScript objects.

	========================================================================
	Live Example:  https://liveweave.com/  or https://jsfiddle.net/
	------------------------------------------------------------------------

	HTML:
	----

	<!DOCTYPE html>
	<html>
	<head>
	<title>HTML, CSS and JavaScript demo</title>
	</head>
	<body>

	<p id="dad" class="lw">Hello Weaver!</p>
	<hr/>
	<p id="mom" class="lw">Hello Weaver!</p>

	</body>
	</html>


	CSS:
	----

	.lw { font-size: 40px; }


	JS:
	--

	function Person(first, last, age, eye) {
	    this.firstName = first;
	    this.lastName = last;
	    this.age = age;
	    this.eyeColor = eye;
	    this.name = function() {
	        return this.firstName + " " + this.lastName;
	    };
	}

	var dad = new Person("John", "Doe", 50, "blue");
	var mom = new Person("Sally", "Rally", 48, "green");

	document.getElementById("dad").innerHTML =
	"My father is " + dad.name(); 
	document.getElementById("mom").innerHTML =
	"My mother is " + mom.name(); 



    ========================================================================
*/




// -------------------------------------------------------------------------------------------------
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/prototype
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/call
// -------------------------------------------------------------------------------------------------
// Since JavaScript doesn't exactly have sub-class objects, prototype is a
// useful workaround to make a “base class” object of certain functions that
// act as objects. For example:

// Base Class: Person

var Person = function(name) {
  this.name = name;
  this.canTalk = true;
};

// All People can "Greet"

Person.prototype.greet = function() {
  if (this.canTalk) {
    console.log('Hi, I am ' + this.name);
  }
};


// An Employee (has a title) -- Using call to chain constructors for an object

var Employee = function(name, title) {
  Person.call(this, name);
  this.title = title;
};

Employee.prototype = Object.create(Person.prototype);
Employee.prototype.constructor = Employee;

Employee.prototype.greet = function() {
  if (this.canTalk) {
    console.log('Hi, I am ' + this.name + ', the ' + this.title);
  }
};


// A Customer is also a Person

var Customer = function(name) {
  Person.call(this, name);
};

Customer.prototype = Object.create(Person.prototype);
Customer.prototype.constructor = Customer;


// A Mime can not talk

var Mime = function(name) {
  Person.call(this, name);
  this.canTalk = false;
};

Mime.prototype = Object.create(Person.prototype);
Mime.prototype.constructor = Mime;


// Some Example Projects

var bob = new Employee('Bob', 'Builder');
var joe = new Customer('Joe');
var rg = new Person('Red Green');
var mike = new Customer('Mike');
var mime = new Mime('Mime');


// Test Objects with Prototype Chains

console.log( "--------------")
console.log( "Bob : Employee")
protos(bob)
bob.greet(); // Hi, I am Bob, the Builder
console.log( "--------------")
console.log( "Joe : Customer")
protos(joe)
joe.greet(); // Hi, I am Joe
console.log( "--------------")
console.log( "RG : Person")
protos(rg)
rg.greet(); // Hi, I am Red Green
console.log( "--------------")
console.log( "Mike : Customer")
protos(mike)
mike.greet(); // Hi, I am Mike
console.log( "--------------")
console.log( "Mime : Mime")
protos(mime)
mime.greet();
console.log( "--------------")




















