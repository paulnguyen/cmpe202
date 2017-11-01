
/*

	https://javascript.info/mixins

	Mixins

	In JavaScript we can only inherit from a single object. There can be only
	one [[Prototype]] for an object. And a class may extend only one other
	class.

	But sometimes that feels limiting. For instance, I have a class
	StreetSweeper and a class Bycicle, and want to make a
	StreetSweepingBycicle.

	Or, talking about programming, we have a class Renderer that implements
	templating and a class EventEmitter that implements event handling, and
	want to merge these functionalities together with a class Page, to make a
	page that can use templates and emit events.

	There’s a concept that can help here, called “mixins”.

	As defined in Wikipedia, a mixin is a class that contains methods for use
	by other classes without having to be the parent class of those other
	classes.

	In other words, a mixin provides methods that implement a certain
	behavior, but we do not use it alone, we use it to add the behavior to
	other classes.

*/



// A mixin example - The simplest way to make a mixin in JavaScript is to make
// an object with useful methods, so that we can easily merge them into a
// prototype of any class.

function alert(msg) {
	console.log(msg)
}

// mixin
let sayHiMixin = {
  sayHi() {
    alert("Hello " + this.name);
  },
  sayBye() {
    alert("Bye " + this.name);
  }
};

// usage:
class User {
  constructor(name) {
    this.name = name;
  }
}

// copy the methods
Object.assign(User.prototype, sayHiMixin);

// now User can say hi
new User("Dude").sayHi(); // Hi Dude!


/*

	https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign

    The Object.assign() method is used to copy the values of all enumerable
	own properties from one or more source objects to a target object. It will
	return the target object. 

*/




