

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
