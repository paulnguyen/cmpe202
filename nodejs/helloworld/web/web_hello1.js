
var http = require('http') ;
var s = http.createServer(
    function(req,res) {
        console.log( "I got a request" ) ;
        res.end( "Hey, thanks for calling!\n") ;     
    }
) ;
s.listen(8080) ;

// Test with:  curl -X GET -i localhost:8080