/**

https://davidwalsh.name/nodejs-http-request
https://jsonplaceholder.typicode.com/

curl get http://jsonplaceholder.typicode.com/posts

node 07.httpgetjson.js > output.txt

**/

var http = require('http') ;

function getJsonExample(cb) {

    http.get(
    
    	{
        	host: 'jsonplaceholder.typicode.com',
        	path: '/posts/1'
    	}, 
    	
    	function(res) {
    
        	// explicitly treat incoming data as utf8 (avoids issues with multi-byte chars)
        	res.setEncoding('utf8');

        	// incrementally capture the incoming response body
        	var body = '';
        	res.on('data', function(d) {
            	body += d;
        	});

        	// do whatever we want with the response once it's done
        	res.on('end', function() {
        	
            	try {
            		console.log (body) ;
                	var parsed = JSON.parse(body);
                	console.log( parsed.userId + " " + parsed.title ) ;
            	} catch (err) {
                	console.error('Unable to parse response as JSON', err);
                	return cb(err);
            	}

            	// pass the relevant data back to the callback
           	 	cb(null, {
                	uid: parsed.userId,
                	title: parsed.title,
                    body: parsed.body
            	});
        	});
        	
    	}).on('error', function(err) {
        	// handle errors with the request itself
        	console.error('Error with the request:', err.message);
        	cb(err);
    	});

}

getJsonExample ( 
	function( err, data ) {
		if (!err) {
			console.log( "==============================" ) ;
			console.log( "User: " + data.uid    ) ;
            console.log( "Title: " + data.title ) ;
            console.log( "Body: \n" + data.body   ) ;
			console.log( "==============================" ) ;
		}
	}
)
