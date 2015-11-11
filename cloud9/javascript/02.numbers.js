
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
