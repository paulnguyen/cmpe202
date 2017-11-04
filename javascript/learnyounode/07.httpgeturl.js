
/**

https://nodejs.org/api/http.html
https://nodejs.org/api/http.html#http_class_http_clientrequest
https://nodejs.org/dist/latest-v5.x/docs/api/http.html#http_class_http_clientrequest

node 07.httpgeturl.js www.cnn.com > output.txt


**/


var http = require('http') ;
var url = process.argv[2] ;

var req = http.get( { host: url }, (res) => {
  		
  		console.log('statusCode: ', res.statusCode);
  		console.log('headers: ', res.headers);
  		res.setEncoding('utf8');
  		
  		res.on('data', (body) => {
  			console.log( "\n\n=========================================" );
    		console.log(body);
  			console.log( "=========================================\n\n" );
  		});
  		
  		res.on('end', () => {
    		console.log('No more data in response.')
  		})
	}
)

req.on('error', (e) => {
  console.log(`ERROR: ${e.message}`);
});


/** Alternative:

	const https = require('https');
	
	https.get('https://encrypted.google.com/', (res) => {
	  console.log('statusCode: ', res.statusCode);
	  console.log('headers: ', res.headers);
	
	  res.on('data', (d) => {
	    process.stdout.write(d);
	  });
	
	}).on('error', (e) => {
	  console.error(e);
	});

*/