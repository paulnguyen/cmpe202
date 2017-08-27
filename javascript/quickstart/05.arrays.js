

// JS Arrays
var array1 = [1, 2, 3, 4]
var array2 = ["one", "two", "three", "four"]
var array3 = [ array1, array2 ]
console.log ( array1 ) ;
console.log ( array2 ) ;
console.log ( array3 ) ;


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


