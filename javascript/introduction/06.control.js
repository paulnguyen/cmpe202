/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
*/


// JavaScript has a similar set of control structures to other languages in
// the C family. Conditional statements are supported by if and else; you can
// chain them together if you like:

var name = 'kittens';
if (name == 'puppies') {
  name += ' woof';
} else if (name == 'kittens') {
  name += ' meow';
} else {
  name += '!';
}
console.log( name )
console.log( name == 'kittens meow' ) ;


// JavaScript has while loops and do-while loops. The first is good for basic
// looping; the second for loops where you wish to ensure that the body of the
// loop is executed at least once:

var z = 0
while (z<5) {
  z = z + 1
}
console.log( z )

x = 0
do {
  x = x + 1
}  while (x < 5);
console.log( x )


// JavaScript's for loop is the same as that in C and Java: it lets you
// provide the control information for your loop on a single line.

for (var i = 0; i < 5; i++) {
  console.log( i )
}


// JavaScript also contains two other prominent for loops: for...of

var array = ["one", "two", "three", "four"]
for (let value of array) {
  console.log( value )
}

var object = {p1 : "a", p2 : "b" } ;
for (let property in object) {
  console.log( property, "=", object[property] )
}


// The && and || operators use short-circuit logic, which means whether they
// will execute their second operand is dependent on the first. This is useful
// for checking for null objects before accessing their attributes:

var obj
var name = obj && obj.p1 ;


// Or for caching values (when falsy values are invalid):

var cachedName
function getName() { return "Hello" }
var name = cachedName || (cachedName = getName());
console.log( name )
cachedName = "Foo"
var name = cachedName || (cachedName = getName());
console.log( name )


// JavaScript has a ternary operator for conditional expressions:

var age = 10
var allowed = (age > 18) ? 'yes' : 'no';
console.log( "allowed? ", allowed )


// The switch statement can be used for multiple branches based on a number or string:

var action = "be lazy"
function doNothing() { console.log( "Nothing done!") }
switch (action) {
  case 'draw':
    drawIt();
    break;
  case 'eat':
    eatIt();
    break;
  default:
    doNothing();
}


// If you don't add a break statement, execution will "fall through" to the
// next level. This is very rarely what you want — in fact it's worth
// specifically labeling deliberate fallthrough with a comment if you really
// meant it to aid debugging:

function eatIt() { console.log( "Eating...") }
var a = 2
switch (a) {
  case 1: // fallthrough
  case 2:
    eatIt();
    break;
  default:
    doNothing();
}


// The default clause is optional. You can have expressions in both the switch
// part and the cases if you like; comparisons take place between the two
// using the === operator:

function yay() { console.log ("Yay!") }
function neverhappens() { console.log("Never Happens!") }
switch (1 + 3) {
  case 2 + 2:
    yay();
    break;
  default:
    neverhappens();
}








