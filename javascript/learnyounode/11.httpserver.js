/**

https://nodejs.org/api/http.html

node 11.httpserver.js 8080
> HTTP Server Started on 8080

curl localhost:8080
> <h1>Hello World!</h1>

**/

var http = require('http') ;  
var fs = require('fs') ;
var port = process.argv[2];

var server = http.createServer(
	function (request, response) {  
		body = fs.readFileSync('11.index.html');
	    response.setHeader('Content-Type', 'text/html');
    	response.writeHead(200);
  		response.end( body );
	}
)  

server.listen(port) ;
console.log( `HTTP Server Started on ${port}\n` ) ;


/**  Alternative:

http.createServer(function (req, res) {
  	res.writeHead(200, { 'content-type' : 'text/plain' });
  	fs.createReadStream( "11.index.html" ).pipe(res) ;
}).listen(8080);

**/
