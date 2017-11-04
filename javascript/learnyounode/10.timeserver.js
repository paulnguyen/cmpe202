/**

https://nodejs.org/api/net.html

node 10.timeserver.js
> server running on 8000

telnet localhost 8000
> Connected to localhost.
> Escape character is '^]'.
> Fri Mar 18 2016 13:23:40 GMT-0700 (PDT)
> Connection closed by foreign host.


**/

var net = require('net') ;
var fs = require('fs') ;

var server = net.createServer( (socket) => {
  var now = new Date();
  socket.end(now.toString()+"\n");
}).on('error', (err) => {
  // handle errors here
  throw err;
});

// grab port 8000
server.listen(8000)  
console.log('server running on 8000');


// grab a random port.

/*
server.listen( () => {
  address = server.address();
  console.log('server running on %j', address);
});
*/

