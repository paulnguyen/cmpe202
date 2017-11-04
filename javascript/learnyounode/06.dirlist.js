/*

https://nodejs.org/api/modules.html
https://nodejs.org/dist/latest-v5.x/docs/api/modules.html
http://www.sitepoint.com/understanding-module-exports-exports-node-js/

node 06.dirlist.js . .md

>  README.md
> [ 'README.md' ]


*/

var module = require('./06.module')  ; 
var dir = process.argv[2] ;
var ext = process.argv[3] ;

// Print Inside Module Version
module.listdir( dir, ext ) ;

// Callback Version (Print Outside Module)
module.getfiles( 
	dir, 
	ext,
	function (err, list) { if (!err) console.log(list) ; }
) ;
