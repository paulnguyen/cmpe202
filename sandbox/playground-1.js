

// JS Objects Playground
//
// * http://www.objectplayground.com/


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

bar = new Bar( "Bar", "Mr.")
foo = new Foo( "Foo")

this.foo = foo
this.bar = bar