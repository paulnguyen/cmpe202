
/**

http://callbackhell.com/
http://book.mixu.net/node/ch7.html

node 09.httpasync1.js www.google.com www.cnn.com www.yahoo.com > output.txt

**/

var http = require('http') ;

var url1 = process.argv[2] ;
var url2 = process.argv[3] ;
var url3 = process.argv[4] ;

function urlget( url, callback ) { 

	var req = http.get( { host: url }, (res) => {
	  		
	  		var buffer = "" ;
	  		
	  		console.log ( 'URL', url ) ;
	  		res.setEncoding('utf8');
	  		
	  		res.on('data', (body) => {
	    		buffer += body ;
	  		});
	  		
	  		res.on('end', () => {
	  			callback( buffer ) ;
	  		})
		}
	)
	
	req.on('error', (e) => {
	  console.log(`ERROR: ${e.message}`);
	});

}

// Final Task

function final() { 
	console.log('Done') ;
	results.forEach( function(buffer) {
		console.log( "===================================" ) ;
		console.log(buffer.length) ;
		console.log( "-----------------------------------" ) ;
		console.log(buffer) ;
		console.log( "===================================" ) ;
	})
}

// A simple async series (http://book.mixu.net/node/ch7.html)

var items = [ url1, url2, url3 ];
var results = [];
function series(item) {
  if(item) {
    urlget( item, function(result) {
      results.push(result);
      return series(items.shift());
    });
  } else {
    return final();
  }
}
series(items.shift());



