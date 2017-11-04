/*

https://nodejs.org/api/fs.html
https://nodejs.org/dist/latest-v5.x/docs/api/fs.html
https://github.com/maxogden/art-of-node#callbacks

node 04.asyncio.js 01.hello.js

> 12

*/

var fs = require('fs') ;

fs.readFile(process.argv[2], 
	function read(err, data) {
    	if (err) {
        	throw err;
    	}
    	//console.log( typeof data ) ;
    	buf = data;
		var str = buf.toString();
		console.log(str.split("\n").length-1); 
	}
) ;

