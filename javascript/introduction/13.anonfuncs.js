/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

  JavaScript lets you create anonymous functions.

*/


var avg = function() {
  var sum = 0;
  for (var i = 0, j = arguments.length; i < j; i++) {
    sum += arguments[i];
  }
  return sum / arguments.length;
};

// This is semantically equivalent to the function avg() form. It's extremely
// powerful, as it lets you put a full function definition anywhere that you
// would normally put an expression. This enables all sorts of clever tricks.
// Here's a way of "hiding" some local variables — like block scope in C:

var a = 1;
var b = 2;

(function() {
  var b = 3;
  a += b;
})();

console.log( a ) ; // 4
console.log( b ) ; // 2


// avaScript allows you to call functions recursively. This is particularly
// useful for dealing with tree structures, such as those found in the browser
// DOM.

/* 

function countChars(elm) {
  if (elm.nodeType == 3) { // TEXT_NODE
    return elm.nodeValue.length;
  }
  var count = 0;
  for (var i = 0, child; child = elm.childNodes[i]; i++) {
    count += countChars(child);
  }
  return count;
}

*/


// This highlights a potential problem with anonymous functions: how do you
// call them recursively if they don't have a name? JavaScript lets you name
// function expressions for this. You can use named IIFEs (Immediately Invoked
// Function Expressions) as shown below:

/* 

var charsInBody = (function counter(elm) {
  if (elm.nodeType == 3) { // TEXT_NODE
    return elm.nodeValue.length;
  }
  var count = 0;
  for (var i = 0, child; child = elm.childNodes[i]; i++) {
    count += counter(child);
  }
  return count;
})(document.body);

*/


// he name provided to a function expression as above is only available to the
// function's own scope. This allows more optimizations to be done by the
// engine and results in more readable code. The name also shows up in the
// debugger and some stack traces, which can save you time when debugging.

// Note that JavaScript functions are themselves objects — like everything
// else in JavaScript — and you can add or change properties on them just like
// we've seen earlier in the Objects section.
