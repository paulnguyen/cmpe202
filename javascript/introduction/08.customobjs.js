/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	Also: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects

*/

//  In classic Object Oriented Programming, objects are collections of data
//  and methods that operate on that data. JavaScript is a prototype-based
//  language that contains no class statement, as you'd find in C++ or Java
//  (this is sometimes confusing for programmers accustomed to languages with
//  a class statement). Instead, JavaScript uses functions as classes. Let's
//  consider a person object with first and last name fields. There are two
//  ways in which the name might be displayed: as "first last" or as "last,
//  first". Using the functions and objects that we've discussed previously,
//  we could display the data like this:

function makePerson(first, last) {
  return {
    first: first,
    last: last
  };
}
function personFullName(person) {
  return person.first + ' ' + person.last;
}
function personFullNameReversed(person) {
  return person.last + ', ' + person.first;
}

s = makePerson('Simon', 'Willison');
personFullName(s); // "Simon Willison"
personFullNameReversed(s); // "Willison, Simon"


// This works, but it's pretty ugly. You end up with dozens of functions in
// your global namespace. What we really need is a way to attach a function to
// an object. Since functions are objects, this is easy:

function makePerson(first, last) {
  return {
    first: first,
    last: last,
    fullName: function() {
      return this.first + ' ' + this.last;
    },
    fullNameReversed: function() {
      return this.last + ', ' + this.first;
    }
  };
}

s = makePerson('Simon', 'Willison');
s.fullName(); // "Simon Willison"
s.fullNameReversed(); // "Willison, Simon"


// There's something here we haven't seen before: the this keyword. Used
// inside a function, this refers to the current object. What that actually
// means is specified by the way in which you called that function. If you
// called it using dot notation or bracket notation on an object, that object
// becomes this. 
//
// If dot notation wasn't used for the call, this refers to the
// global object.

// Note that this is a frequent cause of mistakes. For example:
// When we call fullName() alone, without using s.fullName(), this is bound to
// the global object. Since there are no global variables called first or last
// we get undefined for each one.

s = makePerson('Simon', 'Willison');
var fullName = s.fullName;
fullName(); // undefined undefined

console.log( s.fullName )
console.log( s.fullName() )
console.log( fullName ) 
console.log( fullName() )
console.log( s["fullName"] )
console.log( s["fullName"]() )


// We can take advantage of the this keyword to improve our makePerson function:

function Person(first, last) {
  this.first = first;
  this.last = last;
  this.fullName = function() {
    return this.first + ' ' + this.last;
  };
  this.fullNameReversed = function() {
    return this.last + ', ' + this.first;
  };
}
var s = new Person('Simon', 'Willison');

// We have introduced another keyword: new. new is strongly related to this.
// It creates a brand new empty object, and then calls the function specified,
// with this set to that new object. Notice though that the function specified
// with this does not return a value but merely modifies the this object. It's
// new that returns the this object to the calling site. Functions that are
// designed to be called by new are called constructor functions. Common
// practice is to capitalize these functions as a reminder to call them with
// new.  Note: The improved function still has the same pitfall with calling
// fullName() alone.


// Our person objects are getting better, but there are still some ugly edges
// to them. Every time we create a person object we are creating two brand new
// function objects within it — wouldn't it be better if this code was shared?

function personFullName() {
  return this.first + ' ' + this.last;
}
function personFullNameReversed() {
  return this.last + ', ' + this.first;
}
function Person(first, last) {
  this.first = first;
  this.last = last;
  this.fullName = personFullName;
  this.fullNameReversed = personFullNameReversed;
}

// That's better: we are creating the method functions only once, and
// assigning references to them inside the constructor. Can we do any better
// than that? The answer is yes:

function Person(first, last) {
  this.first = first;
  this.last = last;
}

Person.prototype.fullName = function() {
  return this.first + ' ' + this.last;
};

Person.prototype.fullNameReversed = function() {
  return this.last + ', ' + this.first;
};


// Person.prototype is an object shared by all instances of Person. It forms
// part of a lookup chain (that has a special name, "prototype chain"): any
// time you attempt to access a property of Person that isn't set, JavaScript
// will check Person.prototype to see if that property exists there instead.
// As a result, anything assigned to Person.prototype becomes available to all
// instances of that constructor via the this object.

// This is an incredibly powerful tool. JavaScript lets you modify something's
// prototype at any time in your program, which means you can add extra
// methods to existing objects at runtime:

s = new Person('Simon', 'Willison');
// s.firstNameCaps(); // TypeError on line 1: s.firstNameCaps is not a function

Person.prototype.firstNameCaps = function firstNameCaps() {
  return this.first.toUpperCase();
};
s.firstNameCaps(); // "SIMON"

// Interestingly, you can also add things to the prototype of built-in
// JavaScript objects. Let's add a method to String that returns that string
// in reverse:

var s = 'Simon';
// s.reversed(); // TypeError on line 1: s.reversed is not a function

String.prototype.reversed = function reversed() {
  var r = '';
  for (var i = this.length - 1; i >= 0; i--) {
    r += this[i];
  }
  return r;
};

console.log( s.reversed() ) ; // nomiS

// Our new method even works on string literals!

console.log( 'This can now be reversed'.reversed() ) ; // desrever eb won nac sihT

// As mentioned before, the prototype forms part of a chain. The root of that
// chain is Object.prototype, whose methods include toString() — it is this
// method that is called when you try to represent an object as a string. This
// is useful for debugging our Person objects:

var s = new Person('Simon', 'Willison');
s.toString(); // [object Object]

Person.prototype.toString = function() {
  return '<Person: ' + this.fullName() + '>';
}

console.log( s.toString() ) ; // "<Person: Simon Willison>"
console.log( s ) ;


// Remember how avg.apply() had a null first argument? We can revisit that
// now. The first argument to apply() is the object that should be treated as
// 'this'. For example, here's a trivial implementation of new:

function trivialNew(constructor, ...args) {
  var o = {}; // Create an object
  constructor.apply(o, args);
  return o;
}

// This isn't an exact replica of new as it doesn't set up the prototype chain
// (it would be difficult to illustrate). This is not something you use very
// often, but it's useful to know about. In this snippet, ...args (including
// the ellipsis) is called the "rest arguments" — as the name implies, this
// contains the rest of the arguments.

// Calling
var bill = trivialNew(Person, 'William', 'Orange');

// s therefore almost equivalent to
var bill = new Person('William', 'Orange');

// apply() has a sister function named call, which again lets you set this but
// takes an expanded argument list as opposed to an array.

function lastNameCaps() {
  return this.last.toUpperCase();
}

var s = new Person('Simon', 'Willison');
lastNameCaps.call(s);

// Is the same as:

s.lastNameCaps = lastNameCaps;
s.lastNameCaps(); // WILLISON




