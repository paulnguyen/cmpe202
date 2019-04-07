
//=== OBJECTS ===

var obj1 = new Object() ;
var obj2 = {} ; // literal notation
var obj3 = {p1 : "a", p2 : "b" } ;

// json

json = { "p1" : "a", "p2" : "b" } ;   // property names also need to be quoted.
                                      // standard is double-quoted strings ""
                                      // but, some JS engines also support single

json["p1"] ; // "a"
json.p1 ; // "a"
json.length ; // undefined
Object.keys(json) ; // [ 'p1', 'p2' ]
Object.keys(json).length ; // 2

