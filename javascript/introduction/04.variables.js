/*
	REF:  https://developer.mozilla.org/en-US/docs/Web/JavaScript/A_re-introduction_to_JavaScript
*/


/*
	New variables in JavaScript are declared using one of three keywords: 
		1. let
		2. const 
		3. var
*/


/* 
	======================================================================
	let allows you to declare block-level variables. The declared variable
	is available from the block it is enclosed in.
	======================================================================
*/

let a;
let name = 'Simon';

// The following is an example of scope with a variable declared with let: 

console.log( "Variable Scope Example:" )
for (let myLetVariable = 0; myLetVariable < 5; myLetVariable++) {
  console.log( myLetVariable ) // myLetVariable is only visible in here
}
// console.log( myLetVariable ) // variable not defined



/* 
	======================================================================
	const allows you to declare variables whose values are never intended to
   	change. The variable is available from the block it is declared in.
	======================================================================
 */

const Pi = 3.14; // variable Pi is set 
// Pi = 1;  // will throw an error because you cannot change a constant variable.



/*     
	======================================================================
	var is the most common declarative keyword. It does not have the
	restrictions that the other two keywords have. This is because it was
	traditionally the only way to declare a variable in JavaScript. A variable
	declared with the var keyword is available from the function it is declared
	in.
	======================================================================
*/

var b; 
var test = 'Simon';

// If you declare a variable without assigning any value to it, its type is undefined.


/*
	======================================================================
	An important difference between JavaScript and other languages like Java
	is that in JavaScript, blocks do not have scope; only functions have
	scope. So if a variable is defined using var in a compound statement (for
	example inside an if control structure), it will be visible to the entire
	function. However, starting with ECMAScript 2015, let and const
	declarations allow you to create block-scoped variables.
	======================================================================
*/

console.log( "VarScopeTest1()" )
function VarScopeTest1() {
	var x = 0;
	z = 10
	console.log( "i =", i )
	console.log( "z = ", z )
	for ( var i = 1; i<2; i++ ) {
		var z = 100
		console.log( "hello" )
	}
	console.log( "z = ", z )
}

VarScopeTest1()


console.log( "VarScopeTest2()" )
function VarScopeTest2() {
	var x = 0;
	console.log( "x1 =", x )
	f = function () {
		console.log( "x2 = ", x, " z2 = ", z )
	}
	console.log( "z1 = ", z )
	var z = 10
	return f
}

func = VarScopeTest2()
func()


