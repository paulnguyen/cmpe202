
/*

	http://www.dofactory.com/javascript/singleton-design-pattern

	Singleton Pattern

	In software engineering, the singleton pattern is a design pattern that
	restricts the instantiation of a class to one object. This is useful when
	exactly one object is needed to coordinate actions across the system. The
	concept is sometimes generalized to systems that operate more efficiently when
	only one object exists, or that restrict the instantiation to a certain number
	of objects. The term comes from the mathematical concept of a singleton.


*/


// The Singleton object is implemented as an IIFE. The function executes
// immediately by wrapping it in brackets followed by two additional brackets.
// It is called anonymous because it doesn’t have a name.


var Singleton = (function () {
  var instance;
 
  function createInstance() {
    var object = new Object('I am the instance');
    return object;
  }
 
  return {
    getInstance: function () {
      if (!instance) {
        instance = createInstance();
      }

      return instance;
    }
  };
})();
 
function run() {

  var instance1 = Singleton.getInstance();
  var instance2 = Singleton.getInstance();
 
  console.log( instance1 )
  console.log( instance2 )

  console.assert(instance1 === instance2);
}

run();


