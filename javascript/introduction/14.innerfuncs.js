/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

	Inner Functions:

	JavaScript function declarations are allowed inside other functions. We've
	seen this once before, with an earlier makePerson() function. An important
	detail of nested functions in JavaScript is that they can access variables
	in their parent function's scope:

*/

function parentFunc() {
  var a = 1;

  function nestedFunc() {
    var b = 4; // parentFunc can't use this
    return a + b; 
  }
  return nestedFunc(); // 5
}

// This provides a great deal of utility in writing more maintainable code. If
// a function relies on one or two other functions that are not useful to any
// other part of your code, you can nest those utility functions inside the
// function that will be called from elsewhere. This keeps the number of
// functions that are in the global scope down, which is always a good thing.

// This is also a great counter to the lure of global variables. When writing
// complex code it is often tempting to use global variables to share values
// between multiple functions — which leads to code that is hard to maintain.
// Nested functions can share variables in their parent, so you can use that
// mechanism to couple functions together when it makes sense without
// polluting your global namespace — "local globals" if you like. This
// technique should be used with caution, but it's a useful ability to have.
