
//=== BASIC TYPES ===

var x ; // undefined
x = null ; // defined as null
x = {} ; // object
x.abcde ; // undefined property in object
typeof x ; // object
typeof function() { console.log("hello") ; } // function
typeof "hello" ; // string
typeof 123 ; // number


//=== NUMBERS ===

// numbers = 64-bit double precision floating point
// http://en.wikipedia.org/wiki/Double-precision_floating-point_format

typeof 12335 ; // number
123445 * 567890 ; // integer
0.1 + 0.2 ; // approximation .30000000000004
1 - 0.3 + 0.1 == 0.8 ; // false due to aproximation
123456 / 12 ; // result is a floating point
Math.ceil(10/3) ; // 4
Math.floor(10/3 ) // 3
5 / 0 ; // Infinity
-5 / 0 ; // -Infinity
parseInt('1234567890') ;
parseFloat('1234567.123') ;
parseInt('not a number') ; // NaN
var x = 'cat' ;
isNaN(parseFloat(x)) ; // true
isFinite(12345) ; // true
isFinite(123.45) ; // true
isFinite(NaN) ; // false
true ;   // boolean
false ;  // boolean
Boolean('12345') ; // true
false ; // false, 0, "", NaN, null, undefined
true ;  // all other values


//=== STRINGS ===

// strings 16-bit unicode (ucs2)

"x" ; // no chars, use string
'abc' ;
"abc" ;  // single or double is fine
"abc's" ; // no escape
'abc\'s' ; // have to escape
var x = "12345678" ;
x.length ; // 8
"12345678".length ; // 8
"abc" + "123" ; // concat strings
"abc" + 123 ; // converts 123 to string
5 + 3 + " number" ; // 8 number
"abcdefg".indexOf( "def" ) ; // 3
"abcdefg".substr(3,3) ; // def
"abcdefg".slice(3,6) ; // def
"a,b,c,d,e,f".split(",") ; //  ['a','b','c','d','e','f']
"   ab   c  defg   ".trim() ; // 'ab   c  defg'

/*
> 5+3
8
> 5+3+"hello"
'8hello'
> 5+(3+"hello")
'53hello'
*/


// === REGULAR EXPRESSIONS ===

/[aA]{2,}/                        // same as new RegExp("[aA]{2,}") ; -- search for 2 or more lower or upper A's
"aaoo".search(/[aA]{2,}/) ;       // at index 0
"aaoo".search(/[oO]{2,}/) ;       // at index 2
"boo".search(/[aA]{2,}/) ;        // at index -1
"aaoo".replace(/[aA]{2,}/, "b") ; // 'boo'



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



//=== ARRAYS ===

var arr1 = new Array() ;   // new empty array
var arr2 = [] ; // literal notation
var arr3 ;

arr2 ; // []
arr2.length ; // 0
typeof arr2 ; // 'object'
Array.isArray(arr2) ; // true  -- node only extension


arr3 = [ 'a', 'b', 'c' ] ;
arr3.length ; // 3
for (var i=0; i<arr3.length; i++) { console.log(arr3[i]) ; } // print elements
arr3[arr3.length] = 'd' ;
arr3.push('e') ;

/*
> arr3
[ 'a',
  'b',
  'c',
  'e',
  'd',
  'e' ]
  */

arr3.length ; // 6
arr3[13] = 'Z' ;
arr3.length; // 14


/*
> arr3
[ 'a',
  'b',
  'c',
  'e',
  'd',
  'e',
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  'Z' ]
  */

delete arr3[2] ;

/*
> arr3
[ 'a',
  'b',
  ,
  'e',
  'd',
  'e',
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  'Z' ]
  */

arr3.splice(2,2) ;
arr3.length ;
arr3 ;

/*
> arr3.splice(2,2) ;
[ , 'e' ]
> arr3.length ;
12
> arr3 ;
[ 'a',
  'b',
  'd',
  'e',
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  'Z' ]
*/

var nums = [1, 2, 3, 4, 5, 6] ;
nums.length ;
nums.push(111) ;
nums ;
nums.length ;
nums.pop() ;
nums ;

/*
> var nums = [1, 2, 3, 4, 5, 6] ;
undefined
> nums.length ;
6
> nums.push(111) ;
7
> nums ;
[ 1,
  2,
  3,
  4,
  5,
  6,
  111 ]
> nums.length ;
7
> nums.pop() ;
111
> nums ;
[ 1,
  2,
  3,
  4,
  5,
  6 ]
> 
*/

nums.unshift(-10) ;
nums ;
nums.shift() ;
nums ;

/*
> nums.unshift(-10) ;
7
> nums ;
[ -10,
  1,
  2,
  3,
  4,
  5,
  6 ]
> nums.shift() ;
-10
> nums ;
[ 1,
  2,
  3,
  4,
  5,
  6 ]
> 
*/

"1,2,3,4,5,6".split(',') ;
[1,2,3,4,5,6].join(':') ;

/*
> "1,2,3,4,5,6".split(',') ;
[ '1',
  '2',
  '3',
  '4',
  '5',
  '6' ]
> [1,2,3,4,5,6].join(':') ;
'1:2:3:4:5:6'
*/

var nums_unsorted = [3, 1, 8, 2, 5, 1] ;
nums_unsorted.sort() ;

/*
> var nums_unsorted = [3, 1, 8, 2, 5, 1] ;
undefined
> nums_unsorted.sort() ;
[ 1,
  1,
  2,
  3,
  5,
  8 ]
> 
*/

var names_unsorted = ['marc', 'Maria', 'Alfred', 'zimbu'] ;
names_unsorted.sort() ;

/*
> var names_unsorted = ['marc', 'Maria', 'Alfred', 'zimbu'] ;
undefined
> names_unsorted.sort() ;  // upper case higher priority
[ 'Alfred',
  'Maria',
  'marc',
  'zimbu' ]
*/

var names = ['marc', 'Maria', 'Alfred', 'zimbu'] ;
names.sort(
    function(a,b) {
        var a1 = a.toLowerCase();
        var b1 = b.toLowerCase() ;
        if (a1<b1) return -1 ;
        if (a1>b1) return 1 ;
        return 0 ;
    }    
) ;

/*
> var names = ['marc', 'Maria', 'Alfred', 'zimbu'] ;
undefined
> names.sort(
...     function(a,b) {
.....         var a1 = a.toLowerCase();
.....         var b1 = b.toLowerCase() ;
.....         if (a1<b1) return -1 ;
.....         if (a1>b1) return 1 ;
.....         return 0 ;
.....     }    
... ) ;
[ 'Alfred',
  'marc',
  'Maria',
  'zimbu' ]
> 
*/

// forEach extension in Node and V8

names ;
names.forEach( function(value) { console.log(value) ; } ) ;
 
 /*
> names ;
[ 'Alfred',
  'marc',
  'Maria',
  'zimbu' ]
> names.forEach( function(value) { console.log(value) ; } ) ;
Alfred
marc
Maria
zimbu
*/


//=== FUNCTIONAL PROGRAMMING ===

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




