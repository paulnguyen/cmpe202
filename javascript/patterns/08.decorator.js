
/*

	http://www.dofactory.com/javascript/decorator-design-pattern

	Decorator

	Attach additional responsibilities to an object dynamically. Decorators
	provide a flexible alternative to subclassing for extending functionality.

	Decorators provide flexibility to statically typed languages by allowing
	runtime changes as opposed to inheritance which takes place at compile
	time. JavaScript, however, is a dynamic language and the ability to extend
	an object at runtime is baked into the language itself.

	For this reason, the Decorator pattern is less relevant to JavaScript
	developers. In JavaScript the Extend and Mixin patterns subsume the
	Decorator pattern.

*/

function alert(msg) {
	console.log(msg)
}

var User = function(name) {
    this.name = name;
 
    this.say = function() {
        log.add("User: " + this.name);
    };
}
 
var DecoratedUser = function(user, street, city) {
    this.user = user;
    this.name = user.name;  // ensures interface stays the same
    this.street = street;
    this.city = city;
 
    this.say = function() {
        log.add("Decorated User: " + this.name + ", " +
                   this.street + ", " + this.city);
    };
}
 
// logging helper
 
var log = (function() {
    var log = "";
 
    return {
        add: function(msg) { log += msg + "\n"; },
        show: function() { alert(log); log = ""; }
    }
})();
 
function run() {
 
    var user = new User("Kelly");
    user.say();
 
    var decorated = new DecoratedUser(user, "Broadway", "New York");
    decorated.say();
 
    log.show();
}

run()