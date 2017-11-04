/*

https://nodejs.org/api/modules.html
https://nodejs.org/dist/latest-v5.x/docs/api/modules.html
http://www.sitepoint.com/understanding-module-exports-exports-node-js/

*/


var fs = require('fs') ;
var path = require('path');

/*

exports.listdir = function(dir, ext) {
	console.log( dir + " " + ext ) ;
	fs.readdir(dir, 
		function read(err, files) {
	    	if (err) {
	        	throw err;
	    	}
			for (var i=0; i<files.length; i++) { 
				fext = path.extname(files[i]) ;			
				if ( ext == fext)
				{
					console.log(files[i]) ; 
				}
			} // print elements matching filter
		}
	) 

}

*/


module.exports = {

  listdir: function(dir, ext) {
		fs.readdir(dir, 
			function read(err, files) {
	    		if (err) {
	        		throw err;
	    		}
				for (var i=0; i<files.length; i++) { 
					fext = path.extname(files[i]) ;			
					if ( ext == fext)
					{
					console.log(files[i]) ; 
					}
				} 
			}
		) 
	},       

  getfiles: function(dir, ext, callback) {
		fs.readdir(dir, 
			function read(err, files) {
				var return_list = [] ;
	    		if (err) {
	        		throw err;
	    		}
				for (var i=0; i<files.length; i++) { 
					fext = path.extname(files[i]) ;			
					if ( ext == fext)
					{
						return_list.push( files[i] ) ;
					}
				} 
				callback( null, return_list ) ;
			}
		) 
	}       

  
};