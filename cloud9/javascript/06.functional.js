

//=== FUNCTIONAL PROGRAMMING ===

function square (number)
{ return number*number; }

/*
js> square(10)
100
js> square(4)
16
*/

function hello(name) {
    console.log( "Hello there " + name ) ;
}

/*
> hello( "John" ) ;
Hello there John
undefined
> hello() ;                 // params not validated
Hello there undefined
undefined
> 
> hello( "John", "Tom", "Jerry" ) ;
Hello there John
undefined
*/


function hello2() {
    console.log( arguments ) ;  // display a list of function args
}

/*
> hello2( "John", "Tom", "Jerry", 1234 ) ;
{ '0': 'John', '1': 'Tom', '2': 'Jerry', '3': 1234 }
undefined
> 
*/


// 1. () -- use default values
// 2. (number) -- cache size only
// 3. (object) -- we'll use those instead

function init_cache() {
    var init_data = {
        cache_size: 10,
        location: "/tmp",
        type: "btree"
    } ;
    var a = arguments ;
    for (var i=0; i<a.length; i++) {
        if (typeof a[i] == 'number') {
            init_data.cache_size = a[i] ;
        }
        else if (typeof a[i] == 'object') {
            init_data = a[i] ;
        }
        else {
            throw new Error( "Bad Params to init_cache" ) ;
        }
    }
}

init_cache() ;
init_cache(100) ;
init_cache( {
    cache_size: 50,
    location: "/var",
    type: "avltree"
}) ;


// anonymous functions

var x = function (a, b) { return a + b ; }
x(2, 3) ;   // 5

var y = function() { throw new Error("Boo!"); }  // hard to debug
try {
  y() ;
} catch (err)
{
  console.log( err ) ;
}


// function scope
var pet = "cat" ;
function play_with_pets() {
    var pet = "dog" ;
    console.log(pet) ;
}

/*
> play_with_pets() ;
dog
undefined
> pet
'cat'
*/

var height = 5 ;
var radius = 3 ;
var volume ;

(function() {
    var pir2 = Math.PI * radius * radius ;
    volume = pir2 * height / 3 ;
})() ;

/*
> var height = 5 ;
undefined
> var radius = 3 ;
undefined
> var volume ;
undefined
> 
undefined
> (function() {
...     var pir2 = Math.PI * radius * radius ;
...     volume = pir2 * height / 3 ;
... })() ;
undefined
> volume;
47.1238898038469
> pir2;
ReferenceError: pir2 is not defined
    at repl:1:1
    at REPLServer.self.eval (repl.js:110:21)
    at repl.js:249:20
    at REPLServer.self.eval (repl.js:122:7)
    at Interface.<anonymous> (repl.js:239:12)
    at Interface.emit (events.js:95:17)
    at Interface._onLine (readline.js:202:10)
    at Interface._line (readline.js:531:8)
    at Interface._ttyWrite (readline.js:760:14)
    at ReadStream.onkeypress (readline.js:99:10)
> 
*/





