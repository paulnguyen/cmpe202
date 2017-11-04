
/**

https://nodejs.org/api/http.html#http_class_http_clientrequest
https://nodejs.org/api/events.html#events_class_events_eventemitter
http://www.w3schools.com/jsref/jsref_length_array.asp

node 08.httpcollect.js www.cnn.com > output.txt

**/


var http = require('http') ;
var url = process.argv[2] ;

var req = http.get( { host: url }, (res) => {
  		
  		var buffer = "" ;
  		
  		console.log('statusCode: ', res.statusCode);
  		console.log('headers: ', res.headers);
  		res.setEncoding('utf8');
  		
  		res.on('data', (body) => {
    		buffer += body ;
  		});
  		
  		res.on('end', () => {
  			console.log( "===================================" ) ;
    		console.log(buffer.length) ;
  			console.log( "===================================" ) ;
    		console.log(buffer) ;
  			console.log( "===================================" ) ;
  		})
	}
)

req.on('error', (e) => {
  console.log(`ERROR: ${e.message}`);
});




