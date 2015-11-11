
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



