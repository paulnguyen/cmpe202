
/**

http://callbackhell.com/
https://www.npmjs.com/package/async

npm install async
var async = require("async") ;

node 09.httpasync2.js www.google.com www.cnn.com www.yahoo.com 

**/

var http = require('http') ;
var async = require("async") ;

function urlget( url, callback ) { 

	var req = http.get( { host: url }, (res) => {
	  		
	  		var buffer = "" ;
	  		
	  		console.log ( 'URL', url ) ;
	  		res.setEncoding('utf8');
	  		
	  		res.on('data', (body) => {
	    		buffer += body ;
	  		});
	  		
	  		res.on('end', () => {
	  			callback( null, buffer ) ;
	  		})
		}
	)
	
	req.on('error', (e) => {
	  console.log(`ERROR: ${e.message}`);
	});

}

var url1 = process.argv[2] ;
var url2 = process.argv[3] ;
var url3 = process.argv[4] ;

async.series({
    one: function(c){
        urlget( url1, c ) ;
    },
    two: function(c){
        urlget( url2, c ) ;
    },
    three: function(c){
        urlget( url3, c ) ;
    }
	},
	function(err, results) {
		console.log('Done\n') ;
		console.log( results.one.length ) ;
		console.log( results.one.substring(1,255) ) ;
		console.log( "\n" ) ;
		console.log( results.two.length ) ;
		console.log( results.two.substring(1,255) ) ;
		console.log( "\n" ) ;
		console.log( results.three.length ) ;
		console.log( results.three.substring(1,255) ) ;
	}
);




