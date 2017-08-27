
/*  npm install async

    https://github.com/caolan/async
    also see:  https://github.com/caolan/async#seriestasks-callback
*/

var async = require("async") ;

console.log( "Sync 1, 2, 3..." ) ;

var f1 = function () { console.log("1"); }
var f2 = function () { console.log("2"); }
var f3 = function () { console.log("3"); }

async.series({
    one: function(callback){
        setTimeout(function(){
            f1() ;
            callback(null, 1);
        }, 9000);
    },
    two: function(callback){
        setTimeout(function(){
            f2() ;
            callback(null, 2);
        }, 10000);
    },
    three: function(callback){
        setTimeout(function(){
            f3() ;
            callback(null, 3);
        }, 3000);
    }
});