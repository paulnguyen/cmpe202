/* npm install node-rest-client */

var Client = require('node-rest-client').Client;
var http = require('http') ;
var count = "";

function request_handler (req, res) {
    var client = new Client();
            client.get("http://api.paulnguyen.org:8181/gumball/", function(data, response_raw){
                console.log(data.id) ;
                console.log(data.countGumballs) ;
                console.log(data.modelNumber) ;
                console.log(data.serialNumber) ;
                count = data.countGumballs
            });
    console.log( "count = " + count ) ;
    res.end( "count = " + count + "\n");
}

var s = http.createServer(request_handler) ;
s.listen(8080) ;

// Test with:  curl -X GET -i localhost:8080
