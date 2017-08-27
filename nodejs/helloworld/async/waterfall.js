/*  npm install async */

var async = require("async") ;

async.waterfall([
    function(c){
        c( null, "a" ) ; // "a" is pass as arg1       
    },
    function(arg1, c){
        console.log( "arg1 = " + arg1 ) ;
        c( null, "b", "c" ) ;  // "b" is arg2, "c" is arg3
    },
    function(arg2, arg3, c){
        console.log( "arg2 = " + arg2 ) ;
        console.log( "arg3 = " + arg3 ) ;
        c(null, "done") ;   
    }
],
function(err, results) {
    console.log( "err: " + err ) ;
    console.log( "results: " + results ) ;
}
);

