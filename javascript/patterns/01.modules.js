
/*

	http://jargon.js.org/_glossary/REVEALING_MODULE_PATTERN.md

	Revealing Module Pattern

	This pattern is the same concept as the module pattern in that it focuses
	on public & private methods. The only difference is that the revealing
	module pattern was engineered as a way to ensure that all methods and
	variables are kept private until they are explicitly exposed; usually
	through an object literal returned by the closure from which it’s defined.


*/

console.log( "\nRevealing Module Pattern -  reveal public methods via object literal")

var window = "Test Window"
var MyModule = (function(window, undefined) {

  function myMethod() {
    console.log('my method');
  }

  function myOtherMethod() {
    console.log('my other method');
  }

  // explicitly return public methods when this object is instantiated
  return {
    someMethod: myMethod,
    someOtherMethod: myOtherMethod
  };
})(window);

console.log( MyModule )

//  example usage
// MyModule.myMethod() ; // undefined
// MyModule.myOtherMethod() ; // undefined
MyModule.someMethod() ; // prints 'my method'
MyModule.someOtherMethod() ; // prints 'my other method'


// This pattern can also be implemented using a privately shared cache:
console.log( "\nThis pattern can also be implemented using a privately shared cache ..." )

var MyModule = (function(window,undefined) {

  // this object is used to store private variables and methods across
  // multiple instantiations

  var privates = { a : 1, b : 2 } ;

  function privateFunc() {
  	console.log( "private func...")
  }

  function MyModule() {
    this.myMethod = function myMethod() {
      console.log( 'my method: ', privates.a ) ;
      privateFunc() ;
    };

    this.myOtherMethod = function myOtherMethod() {
      console.log( 'my other method: ', privates.b ) ;
    };
  }

  return MyModule;
})(window);

console.log( MyModule )

// example usage
var myMod = new MyModule();
myMod.myMethod(); // prints 'my method'
myMod.myOtherMethod(); // prints 'my other method'




