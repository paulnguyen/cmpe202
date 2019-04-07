

/*

	http://jargon.js.org/_glossary/IIFE.md

	Immediately Invoked Function Expression

	IIFE (for Immediately Invoked Function Expression) is a function that gets
	called immediately after declaration. It is most often used to create a
	scoping context (a context in which all variables and function definitions
	are scoped).

*/


(function foo () {
  console.log( "foo...")
}());


(function bar () {
  console.log( "bar..." )
})();

