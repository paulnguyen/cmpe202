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
