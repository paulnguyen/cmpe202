
/*

  JavaScript Programming Language 

  https://developer.mozilla.org/en-US/docs/Web/JavaScript
  https://github.com/getify/You-Dont-Know-JS

*/



// === OBJECTS ===

obj1 = new Object() ;
obj2 = {} ; // literal notation
obj3 = {p1 : "a", p2 : "b" } ; // dsl for object construction

json = { "p1" : "a", "p2" : "b" } ;   // property names also need to be quoted.
                                      // standard is double-quoted strings ""
                                      // but, some JS engines also support single

json["p1"] ; // "a"
json.p1 ; // "a"
json.length ; // undefined
Object.keys(json) ; // [ 'p1', 'p2' ]
Object.keys(json).length ; // 2

// === OBJECTS ON-THE-FLY CONSTRUCTION ===

car = {} ;
car.make="ford";
car.model="mustang" ;
car.year = 1969 ;

// === OBJECT PROPS & PROP ARRAY ===

car.make ;
car["make"] ;

function show( obj )
{ var output = "" ;
  for (var prop in obj)
    output += prop + " = " + obj[prop] + " | " ;
  return output ;
} ;

show(car) ;


// === OBJECT CONSTRUCTION SYNTAX ===
//
// * https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Basics

var person = {
  name: ['Bob', 'Smith'],
  age: 32,
  gender: 'male',
  interests: ['music', 'skiing'],
  bio: function() {
    console.log(
    	this.name[0] + ' ' + 
    	this.name[1] + ' is ' + 
    	this.age + ' years old. He likes ' + 
    	this.interests[0] + ' and ' + 
    	this.interests[1] + '.');
  },
  greeting: function() {
    console.log('Hi! I\'m ' + this.name[0] + '.');
  }
};

person ;
String( person.bio )
JSON.stringify(person) 

person.name
person.name[0]
person.age
person.interests[1]
person.bio()
person.greeting()


// === OBJECT CONSTRUCTION WITH FUNCTION ===
//
// * https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Object-oriented_JS
// * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this

function createNewPerson(name) {
  var obj = {};
  obj.name = name;
  obj.greeting = function() {
    console.log('Hi! I\'m ' + obj.name + '.');
  };
  return obj;
}

var salva = createNewPerson('Salva')
salva.name
salva.greeting()

// Alternatively, like a Class
// Binding "this" via new operator

function Person(name) {
  this.name = name;
  this.greeting = function() {
    console.log('Hi! I\'m ' + this.name + '.');
  };
}

var bob = new Person('Bob')
var sarah = new Person('Sarah')

// A more Complete example:

function Person(first, last, age, gender, interests) {
  this.name = {
     first : first,
     last : last
  };
  this.age = age;
  this.gender = gender;
  this.interests = interests;
  this.bio = function() {
    console.log(	this.name.first + ' ' + 
    		this.name.last + ' is ' + 
    		this.age + ' years old. He likes ' + 
    		this.interests[0] + ' and ' + 
    		this.interests[1] + '.');
  };
  this.greeting = function() {
    console.log('Hi! I\'m ' + this.name.first + '.');
  };
}

var bob = new Person('Bob', 'Smith', 32, 'male', ['music', 'skiing']);



// === OTHER WAYS TO CREATE OBJECTS ===

// Using Object() constructor

var person = new Object() ;
person.name = 'Chris';
person['age'] = 38;
person.greeting = function() {
  console.log('Hi! I\'m ' + this.name + '.');
};

var person = new Object( 
  {
  	name: 'Chris',
  	age: 38,
  	greeting: function() {
    	console.log('Hi! I\'m ' + this.name + '.');
  	}
  }
);

// Using the create() method

var clone = Object.create(person) ;
clone
show(clone)
clone.name
clone.greeting()



// === JAVASCRIPT THIS BINDINGS ===
//
// * https://github.com/getify/You-Dont-Know-JS/tree/master/this%20%26%20object%20prototypes
//
//   1. Called with new? Use the newly constructed object. (New Binding)
//   2. Called with call or apply (or bind)? Use the specified object. (Explicit Binding)
//   3. Called with a context object owning the call? Use that context object.  (Implicit Binding)
//   4. Default: undefined in strict mode, global object otherwise. (Default Binding)

var a = "global"

function foo() {
  console.log( this.a );
}

var obj1 = {
  a: 1,
  foo: foo
}

var obj2 = {
  a: 2,
  foo: foo
}

obj1.foo() // implicit binding
obj2.foo() // implicit binding

obj1.foo.call( obj2 ) // explicit binding
obj2.foo.call( obj1 ) // explicit binding

foo()  // default binding

function foo2() {
  "use strict";
  console.log( this.a )
}

foo2() // default binding - no global object


function newfoo() {
  this.a = 3  // new binding when called with new
  this.foo = foo
}

var obj3 = new newfoo() // new binding
obj3.foo() // implicit binding



// === REVEALING MODULE PATTERN ===
// 
// * http://jargon.js.org/_glossary/REVEALING_MODULE_PATTERN.md

var obj1 = {
  a: 1,
  foo: function() {
    console.log( this.a )
  }
}

obj1.a
obj1.foo()


var obj2 = (function() {
    public_a = 1
    private_b = 2
    function private_func() { console.log(private_b) }
    function public_func() { console.log(private_b) }
    return {
      a: public_a,
      foo: public_func
    }
  }
)() ;

// public visibility
obj2.a
obj2.foo()

// these are not defined - private visibility
obj2.b 
obj2.private_func()
obj2.public_func()


// === JSON OBJECTS ===
//
// * https://www.json.org/

// JSON Object
var json_person = {
    "id": 101,
    "name": "John Doe",
    "isStudent": true,
    "scores": [
        10,
        20,
        30,
        40
    ],
    "courses": {
        "major": "Finance",
        "minor": "Marketing"
    }
} ;

// JS Object
var js_person = {
    id: 101,
    name: "John Doe",
    isStudent: true,
    scores: [
        10,
        20,
        30,
        40
    ],
    courses: {
        "major": "Finance",
        "minor": "Marketing"
    },
    printName: function() {
        console.log( this.name ) ;
    }
}


// === PROTOTYPE OBJECTS & PROTOTYPE CHAIN ===
//
// * https://github.com/getify/You-Dont-Know-JS/tree/master/this%20%26%20object%20prototypes


// Basic setup of Inheritance

var parent_object = {
    a: 2
}

// child object linked to parent object
var child_object = Object.create( parent_object ) 
child_object.a


// Getter / Setter Shadowing

var parent_object = {
    a: 2
}

var child_object = Object.create( parent_object )

parent_object.a // 2
child_object.a // 2

parent_object.hasOwnProperty( "a" ) // true
child_object.hasOwnProperty( "a" ) // false

child_object.a++ // oops, implicit shadowing!
child_object

parent_object.a // 2
child_object.a // 3

child_object.hasOwnProperty( "a" ) // true


// Prototype "Class" Functions

function Foo() {
  console.log ( "Hi, I'm Foo!")
}

Foo.prototype; // { }


// Each object created from calling new Foo() will end up with "prototype" 
// linked to this "Foo dot prototype" object.

var a = new Foo();
Object.getPrototypeOf( a ) === Foo.prototype ; // true
a.__proto__


// Class-Like Inheritance Symantics

function Foo(name) {
  this.name = name;
}

Foo.prototype.myName = function() {
  return this.name;
};

var a = new Foo( "a" );
var b = new Foo( "b" );

a.myName(); // "a"
b.myName(); // "b"


// A More Complete Inheritance Example
//
// Note: convention is put put function properties
//       in prototype object to separate from object
//       properties.

function Foo(name) {
  this.name = name;
  this.hello = function() { console.log ("Hello There!  My Name is " + this.name) }
}

Foo.prototype.myName = function() {
  return this.name;
};

function Bar(name, label) {
  Foo.call( this, name );
  this.label = label;
}

// here, we make a new `Bar.prototype`
// linked to `Foo.prototype`
//
// Beware! Now `Bar.prototype.constructor` is gone,
// and might need to be manually "fixed" if you're
// in the habit of relying on such properties!

Bar.prototype = Object.create( Foo.prototype );


// Need to properly "fix" the missing `.constructor`
// property on the new object serving as `Bar.prototype`.
// See Chapter 3 for `defineProperty(..)`.

Object.defineProperty( Bar.prototype, "constructor" , {
  enumerable: false,
  writable: true,
  configurable: true,
  value: Foo    // point `.constructor` at `Foo`
} );


// Child Property
Bar.prototype.myLabel = function() {
  return this.label;
};

// New Foo & Bar Objects
bar = new Bar( "Bar", "Mr.")
foo = new Foo( "Foo")

bar.myName() 
bar.myLabel() 

foo.myName()
foo.hello()
bar.hello()



// === ECMAScript 2015 Classes ===
//
// * https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Inheritance#ECMAScript_2015_Classes
//
// ECMAScript 2015 introduces class syntax to JavaScript as a way to write
// reusable classes using easier, cleaner syntax, which is more similar to
// classes in C++ or Java.


class Person {
  constructor(first, last, age, gender, interests) {
    this.name = {
      first,
      last
    };
    this.age = age;
    this.gender = gender;
    this.interests = interests;
  }

  greeting() {
    console.log(`Hi! I'm ${this.name.first}`);
  };

  farewell() {
    console.log(`${this.name.first} has left the building. Bye for now!`);
  };
}

let han = new Person('Han', 'Solo', 25, 'male', ['Smuggling']);
han.greeting();
// Hi! I'm Han

let leia = new Person('Leia', 'Organa', 19, 'female', ['Government']);
leia.farewell();
// Leia has left the building. Bye for now


class Teacher extends Person {
  constructor(first, last, age, gender, interests, subject, grade) {
    super(first, last, age, gender, interests);

    // subject and grade are specific to Teacher
    this.subject = subject;
    this.grade = grade;
  }
}

let snape = new Teacher('Severus', 'Snape', 58, 'male', ['Potions'], 'Dark arts', 5);
snape.greeting(); // Hi! I'm Severus.
snape.farewell(); // Severus has left the building. Bye for now.
snape.age // 58
snape.subject; // Dark arts



