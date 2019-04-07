/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	Closures:

    This leads us to one of the most powerful abstractions that JavaScript has
	to offer — but also the most potentially confusing. What does this do? 

*/


function makeAdder(a) {
  return function(b) {
    return a + b;
  };
}
var x = makeAdder(5);
var y = makeAdder(20);
x(6); // ?
y(7); // ?


// The name of the makeAdder() function should give it away: it creates new
// 'adder' functions, each of which, when called with one argument, adds it to
// the argument that it was created with.

// What's happening here is pretty much the same as was happening with the
// inner functions earlier on: a function defined inside another function has
// access to the outer function's variables. The only difference here is that
// the outer function has returned, and hence common sense would seem to
// dictate that its local variables no longer exist. But they do still exist —
// otherwise the adder functions would be unable to work. What's more, there
// are two different "copies" of makeAdder()'s local variables — one in which
// a is 5 and one in which a is 20. So the result of those function calls is
// as follows:

console.log( x(6) ) ; // returns 11
console.log( y(7) ) ; // returns 27


// Here's what's actually happening. Whenever JavaScript executes a function,
// a 'scope' object is created to hold the local variables created within that
// function. It is initialized with any variables passed in as function
// parameters. This is similar to the global object that all global variables
// and functions live in, but with a couple of important differences: firstly,
// a brand new scope object is created every time a function starts executing,
// and secondly, unlike the global object (which is accessible as this and in
// browsers as window) these scope objects cannot be directly accessed from
// your JavaScript code. There is no mechanism for iterating over the
// properties of the current scope object, for example.

// So when makeAdder() is called, a scope object is created with one property:
// a, which is the argument passed to the makeAdder() function. makeAdder()
// then returns a newly created function. Normally JavaScript's garbage
// collector would clean up the scope object created for makeAdder() at this
// point, but the returned function maintains a reference back to that scope
// object. As a result, the scope object will not be garbage-collected until
// there are no more references to the function object that makeAdder()
// returned.

// Scope objects form a chain called the scope chain, similar to the prototype
// chain used by JavaScript's object system.

// A closure is the combination of a function and the scope object in which it
// was created. Closures let you save state — as such, they can often be used
// in place of objects. You can find several excellent introductions to
// closures.
//
// REF:  https://stackoverflow.com/questions/111102/how-do-javascript-closures-work



