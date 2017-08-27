

console.log( "Async 1, 2, 3 ..." ) ;

var f1 = function () { console.log("1"); }
var f2 = function () { console.log("2"); }
var f3 = function () { console.log("3"); }

//s1 = function() { setTimeout( f1, 9000); }
s1 = function () {
    setTimeout( function () { 
            console.log("1"); 
            }
    , 9000) ;
}

s2 = function() { setTimeout( f2, 10000); }
s3 = function() { setTimeout( f3, 3000); }

s1() ;
s2() ;
s3() ;

