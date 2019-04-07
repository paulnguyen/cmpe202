/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript

    Along with objects, functions are the core component in understanding
	JavaScript. The most basic function couldn't be much simpler:

*/


function add(x, y) {
  var total = x + y;
  return total;
}

// This demonstrates a basic function. A JavaScript function can take 0 or
// more named parameters. The function body can contain as many statements as
// you like, and can declare its own variables which are local to that
// function. The return statement can be used to return a value at any time,
// terminating the function. If no return statement is used (or an empty
// return with no value), JavaScript returns undefined.

// The named parameters turn out to be more like guidelines than anything
// else. You can call a function without passing the parameters it expects, in
// which case they will be set to undefined.

add(); // NaN
// You can't perform addition on undefined

add(2, 3, 4); // 5
// added the first two; 4 was ignored

// That may seem a little silly, but functions have access to an additional
// variable inside their body called arguments, which is an array-like object
// holding all of the values passed to the function. Let's re-write the add
// function to take as many values as we want:

function add() {
  var sum = 0;
  for (var i = 0, j = arguments.length; i < j; i++) {
    sum += arguments[i];
  }
  return sum;
}

add(2, 3, 4, 5); // 14

// That's really not any more useful than writing 2 + 3 + 4 + 5 though. Let's
// create an averaging function:

function avg() {
  var sum = 0;
  for (var i = 0, j = arguments.length; i < j; i++) {
    sum += arguments[i];
  }
  return sum / arguments.length;
}

avg(2, 3, 4, 5); // 3.5

// This is pretty useful, but it does seem a little verbose. To diminish this
// code a bit more we can look at substituting the use of the arguments array
// through Rest parameter syntax. 
//
// REF: 
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/rest_parameters
//
// In this way we can pass in any number of arguments into the function while
// keeping our code minimal. The rest parameter operator is used in function
// parameter lists with the format: ...variable and it will include within
// that variable the entire list of uncaptured arguments that the function was
// called with. We will also replace the for loop with a for...of loop to
// return the values within our variable.

function avg(...args) {
  var sum = 0;
  for (let value of args) {
    sum += value;
  }
  return sum / args.length;
}

avg(2, 3, 4, 5); // 3.5

// In the above code the variable args holds all the values that were passed
// into the function.
//
// It is important to note that wherever the rest parameter operator is placed
// in a function declaration it will store all arguments after its
// declaration, but not before. i.e. function avg(firstValue, ...args) will
// store the first value passed into the function in the firstValue variable
// and the remaining arguments in args. Another useful function but it does
// lead us to a new problem. The avg() function takes a comma separated list
// of arguments — but what if you want to find the average of an array? You
// could just rewrite the function as follows:

function avgArray(arr) {
  var sum = 0;
  for (var i = 0, j = arr.length; i < j; i++) {
    sum += arr[i];
  }
  return sum / arr.length;
}

avgArray([2, 3, 4, 5]); // 3.5

// But it would be nice to be able to reuse the function that we've already
// created. Luckily, JavaScript lets you call a function with an arbitrary
// array of arguments, using the apply() method of any function object.

avg.apply(null, [2, 3, 4, 5]); // 3.5

// The second argument to apply() is the array to use as arguments; the first
// will be discussed later on. This emphasizes the fact that functions are
// objects too.


// You can achieve the same result using the spread operator in the function call.
//
// REF: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_operator
//
// For instance: avg(...numbers)
// 

