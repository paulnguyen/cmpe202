/*

https://nodejs.org/api/fs.html
https://nodejs.org/api/path.html

node 05.dirlist.js . .md

> README.md

*/

var fs = require('fs') ;
var path = require('path');

var dir = process.argv[2] ;
var ext = process.argv[3] ;

fs.readdir(dir, 
	function read(err, files) {
    	if (err) {
        	throw err;
    	}
		for (var i=0; i<files.length; i++) { 
			fext = path.extname(files[i]) ;			
			if ( ext == fext) // print elements matching filter
			{
				console.log(files[i]) ; 
			}
		} 
	}
) 