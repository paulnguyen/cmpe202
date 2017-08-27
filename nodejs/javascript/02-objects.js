
// === FUNCTIONS ===

function square (number)
{ return number*number; }

/*
js> square(10)
100
js> square(4)
16
*/

// === OBJECTS ON-THE-FLY CONSTRUCTION ===

car = {} ;
car.make="ford";
car.model="mustang" ;
car.year = 1969 ;

/*
js> car = {} ;
[object Object]
js> car.make="ford";
ford
js> car.model="mustang" ;
mustang
js> car.year = 1969 ;
1969
*/

// === OBJECT PROPS & PROP ARRAY ===

car.make ;
car["make"] ;

/*
js> car.make ;
ford
js> car["make"] ;
ford
*/

function show( obj )
{ var r = "" ;
  for (var i in obj)
    r += i + " = " + obj[i] + "\n" ;
  return r ;
}

/*
js> function show( obj )
{ var r = "" ;
  for (var i in obj)
    r += i + " = " + obj[i] + "\n" ;
  return r ;
}

js> show(car) ;
model = mustang
year = 1969
make = ford
*/

// === OBJECT CONSTRUCTION WITH FUNCTION ===

function car( make, model, year )
{
  this.make = make ;
  this.model = model ;
  this.year = year ;
}

mycar1 = new car("Ford", "Mustang", 1969 ) ;
mycar2 = new car("SAAB", "900S", 1995 ) ;

/*
js> mycar1 = new car("Ford", "Mustang", 1969 ) ;
[object Object]

js> mycar2 = new car("SAAB", "900S", 1995 ) ;
[object Object]

js> show(mycar1);
model = Mustang
year = 1969
make = Ford

js> show(mycar2);
model = 900S
year = 1995
make = SAAB
*/

// === FUNCTION OBJECT/PROTOTYPE OBJECT TYPE ===

car.prototype.color = null ;

/*
js> car.prototype.color = null ;
null
js> show(mycar1);
model = Mustang
year = 1969
make = Ford
color = null

js> show(mycar2);
model = 900S
year = 1995
make = SAAB
color = null

js> mycar1.color="red" ;
red
js> show(mycar1);
year = 1969
model = Mustang
make = Ford
color = red
*/


// === METHODS ===

function shownewcar()
{ var r = "" ;
  for (var i in this)
    r += i + " = " + this[i] + "\n" ;
  return r ;
}


function newcar( make, model, year )
{
  this.make = make ;
  this.model = model ;
  this.year = year ;
  this.show = shownewcar ;
}

/*
js> mycar3 = new newcar("Toyota", "Celica", 2002 ) ;
[object Object]
js> mycar3.show() ;
*/

year = 2002
model = Celica
make = Toyota
show =
function shownewcar() {
    var r = "";
    for (var i in this) {
        r += i + " = " + this[i] + "\n";
    }
    return r;
}


car.prototype.show = shownewcar ;

/*
js> car.prototype.show = shownewcar ;
*/

function shownewcar() {
    var r = "";
    for (var i in this) {
        r += i + " = " + this[i] + "\n";
    }
    return r;
}

/*
js> show(mycar1) ;
year = 1969
model = Mustang
make = Ford
color = red
show =
*/

function shownewcar() {
    var r = "";
    for (var i in this) {
        r += i + " = " + this[i] + "\n";
    }
    return r;
}

/*
js> mycar1.show() ;
year = 1969
model = Mustang
make = Ford
color = red
show =
*/

function shownewcar() {
    var r = "";
    for (var i in this) {
        r += i + " = " + this[i] + "\n";
    }
    return r;
}


// === DELETING AN OBJECT PROPERTY ===

delete car.show ;

/*
js> mycar1.show() ;
year = 1969
model = Mustang
make = Ford
color = red
show =
*/

function shownewcar() {
    var r = "";
    for (var i in this) {
        r += i + " = " + this[i] + "\n";
    }
    return r;
}

/*
js> delete mycar1.show ;
true
js> mycar1.show() ;

js: "<stdin>", line 104: uncaught JavaScript exception: 
undefined: show is not a function. (<stdin>;
 line 104)

js> show(mycar1) ;
year = 1969
model = Mustang
make = Ford
color = red
*/



// === OBJECTS/CLOSURE ===

function Account( bal )
{
  this.withdraw = function (amt) { bal = bal - amt }
  this.getbal = function () { return bal ; }
  return this ;
}

var a = new Account( 1000 ) ;
a.withdraw( 20 ) ;
a.withdraw( 30 ) ;
a.getbal() ;

/*
js> a.withdraw( 20 ) ;
js> a.withdraw( 30 ) ;
js> a.getbal() ;
950
*/


