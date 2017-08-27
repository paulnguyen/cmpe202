
/**

Mighty Gumball, Inc.
Version 2.0

- Rudimentary Page Templates using RegEx
- REST Client Calling Grails REST API 
- Client State Validation using HMAC Key-Based Hash 

NodeJS-Enabled Standing Gumball
Model# M102988
Serial# 1234998871109

**/

var endpoint = "http://api.paulnguyen.org:8181/gumball/";


// added in v2: crypto
// crypto functions:  http://nodejs.org/api/crypto.html

var crypto = require('crypto');
var fs = require('fs');
var express = require('express');
var Client = require('node-rest-client').Client;

var app = express();
app.use(express.bodyParser());
app.use("/images", express.static(__dirname + '/images'));

var secretKey = "kwRg54x2Go9iEdl49jFENRM12Mp711QI" ;

var get_hash = function( state, ts ) {

    // http://nodejs.org/api/crypto.html#crypto_crypto_createhmac_algorithm_key
    text = state + "|" + ts + "|" + secretKey ;
    hmac = crypto.createHmac("sha256", secretKey);
    hmac.setEncoding('base64');
    hmac.write(text);
    hmac.end() ;
    hash = hmac.read();
    //console.log( "HASH: " + hash )
    return hash ;

}


var error = function( req, res, msg, ts ) {

    body = fs.readFileSync('./gumball.html');
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);

    state = "error" ;
    hash = get_hash ( state, ts ) ;

    var html_body = "" + body ;
    var html_body = html_body.replace("{message}", msg );
    var html_body = html_body.replace("{ts}", ts );
    var html_body = html_body.replace("{hash}", hash );
    var html_body = html_body.replace(/id="state".*value=".*"/, "id=\"state\" value=\""+state+"\"") ;
    res.end( html_body );
}



var page = function( req, res, state, ts ) {

    body = fs.readFileSync('./gumball.html');
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);

    hash = get_hash ( state, ts ) ;
    console.log( state ) ;

    var client = new Client();
            var count = "";
            client.get( endpoint, 
                function(data, response_raw){
                    console.log(data);
                    count = data.countGumballs
                    console.log( "count = " + count ) ;
                    var msg =   "\n\nMighty Gumball, Inc.\n\nNodeJS-Enabled Standing Gumball\nModel# " + 
                                data.modelNumber + "\n" +
                                "Serial# " + data.serialNumber + "\n" +
                                "\n" + state +"\n\n" ;
                    var html_body = "" + body ;
                    var html_body = html_body.replace("{message}", msg );
                    var html_body = html_body.replace("{ts}", ts );
                    var html_body = html_body.replace("{hash}", hash );
                    var html_body = html_body.replace(/id="state".*value=".*"/, "id=\"state\" value=\""+state+"\"") ;
                    res.end( html_body );
            });
}

var order = function( req, res, state, ts ) {

    var client = new Client();
            var count = 0;
            client.get( endpoint, 
                function(data, response_raw) {
                    count = data.countGumballs ;
                    console.log( "count before = " + count ) ;
                    if ( count > 0 ) {
                        count-- ;
                        var args = {
                            data: {  "countGumballs": count, },
                            headers:{"Content-Type": "application/json"} 
                        };
                        client.put( endpoint, args,
                            function(data, response_raw) {
                                console.log(data);
                                console.log( "count after = " + data.countGumballs ) ;
                                page( req, res, state, ts ) ;
                            } 
                        );
                    }
                    else {
                        error( req, res, "*** OUT OF INVENTORY ***", ts ) ;
                    }
            });
}


var handle_post = function (req, res) {

    console.log( "Post: " + "Action: " +  req.body.event + " State: " + req.body.state + "\n" ) ;
    var hash1 = "" + req.body.hash ;
    var state = "" + req.body.state ;
    var action = "" + req.body.event ;
    var ts = parseInt(req.body.ts) ;
    var now = new Date().getTime() ;
    var diff = ((now - ts)/1000) ;
    hash2 = get_hash ( state, ts ) ;
    console.log( "DIFF:  " +  diff ) ;
    console.log( "HASH1: " + hash1 ) ;
    console.log( "HASH2: " + hash2 ) ;

    if ( diff > 120 || hash1 != hash2 ) {
        error( req, res, "*** SESSION INVALID ***", ts ) ;
    }
    else if ( action == "Insert Quarter" ) {
        if ( state == "no-coin" )
            page( req, res, "has-coin", ts ) ;
        else
            page( req, res, state, ts ) ;
            
    }
    else if ( action == "Turn Crank" ) {
        if ( state == "has-coin" ) {
            hash = get_hash ( "no-coin", ts ) ;
            order(req, res, "no-coin", ts ) ;
        }
        else
            page( req, res, state, ts ) ;
    }  
  
}

var handle_get = function (req, res) {
    console.log( "Get: ..." ) ;

    ts = new Date().getTime()
    console.log( ts )
    state = "no-coin" ;

    page( req, res, state, ts ) ;
}

app.post("*", handle_post );
app.get( "*", handle_get ) ;

console.log( "Server running on Port 8080..." ) ;

app.listen(8080);

