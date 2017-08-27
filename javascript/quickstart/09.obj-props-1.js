

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

