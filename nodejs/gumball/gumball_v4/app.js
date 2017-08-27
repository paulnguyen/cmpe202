

/**

Mighty Gumball, Inc.
Version 4.0

- Removed REST Client Approach to Data Access
- Using MongoDB with Async Framework for Data Management
- Handlebars Page Templates
- Client State Validation using HMAC Key-Based Hash 

NodeJS-Enabled Standing Gumball
Model# M102988
Serial# 1234998871109

**/


// added in v4: mongodb, async
// http://mongodb.github.io/node-mongodb-native/contents.html

// added in v3: handlebars
// https://www.npmjs.org/package/express3-handlebars
// npm install express3-handlebars

// added in v2: crypto
// crypto functions:  http://nodejs.org/api/crypto.html


var crypto = require('crypto');
var fs = require('fs');
var express = require('express');
var Client = require('node-rest-client').Client;

var app = express();
app.use(express.bodyParser());
app.use("/images", express.static(__dirname + '/images'));
handlebars  = require('express3-handlebars');
hbs = handlebars.create();
app.engine('handlebars', hbs.engine);
app.set('view engine', 'handlebars');

var DB = require('mongodb').Db,
    DB_Connection = require('mongodb').Connection,
    DB_Server = require('mongodb').Server,
    async = require('async') ;

/*
var db_host = "ds043220.mongolab.com" ;
var db_port = "43220" ;
var db_user = "user" ;
var db_pwd  = "pwd" ;
var db_name = "db" ;
*/


var db_host = "localhost" ;
var db_port = "27017" ;
var db_user = "cmpe281" ;
var db_pwd  = "cmpe281" ;
var db_name = "test" ;

   

var db = new DB(db_name,
                new DB_Server( db_host, db_port,
                            { auto_reconnect: true,
                             poolSize: 20}),
                            { w: 1 } );

db_init = function (callback) {
    async.waterfall([
        // 1. open database 
        function (cb) {
            console.log("INIT: STEP 1. Open MongoDB...");
            db.open(cb);
        },
        // 2. authenticate
        /*        
        function (result, cb) {
            console.log("INIT: STEP 2. Authenticate...");
            db.authenticate(db_user, db_pwd, function(err, res) {
                        if(!err) {
                            console.log("Authenticated");
                            cb(null, callback) ;
                        } else {
                            console.log("Error in authentication.");
                            console.log(err);
                            process.exit(-1);
                        }
                    });
        },
        */
        // 3. fetch collections
        function (result, cb) {
            console.log("INIT: STEP 3. Fetch Collections...");
            db.collections(cb);
        },

    ], callback);
};


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

    var result = new Object() ;
    state = "error" ;
    hash = get_hash ( state, ts ) ;

    result.msg = msg ;
    result.ts = ts ;
    result.hash = hash ;
    result.state = state ;

    res.render('gumball', {
        state: result.state,
        ts: result.ts,
        hash: result.hash,
        message: result.msg
    });

}


var page = function( req, res, state, ts ) {
  
    db.collection('gumball', function(err, collection) {
        collection.find( {serialNumber: '1234998871109'}).toArray( function(err, results) {

                var data = results[0] ;
                var rec_id = data._id ;
                console.log( "fetched rec id: " + rec_id ) ;
                var result = new Object() ;
                hash = get_hash ( state, ts ) ;
                console.log( state ) ;

                console.log(data);
                count = data.countGumballs
                console.log( "count = " + count ) ;
                var msg =   "\n\nMighty Gumball, Inc.\n\nNodeJS-Enabled Standing Gumball\nModel# " + 
                            data.modelNumber + "\n" +
                            "Serial# " + data.serialNumber + "\n" +
                            "\n" + state +"\n\n" ;
                result.msg = msg ;
                result.ts = ts ;
                result.hash = hash ;
                result.state = state ;

                res.render('gumball', {
                    state: result.state,
                    ts: result.ts,
                    hash: result.hash,
                    message: result.msg
                });

        } ) ;
    } ) ;


}


var order = function( req, res, state, ts ) {

  db.collection('gumball', function(err, collection) {

        collection.find( {serialNumber: '1234998871109'}).toArray( function(err, results) {

                var data = results[0] ;
                var rec_id = data._id ;
                console.log( "updating rec id: " + rec_id ) ;

                count = data.countGumballs ;
                if ( count > 0 ) {
                        count-- ;
                        collection.update({_id : rec_id}, {$set : {countGumballs : count}}, function( err, results) {
                                console.log( "count after = " + count ) ;
                                page( req, res, state, ts ) ;                        
                            }
                        ) ;
                    }
                    else {
                        error( req, res, "*** OUT OF INVENTORY ***", ts ) ;
                    }

        } ) ;


    } ) ;

}


var handle_post = function (req, res, next) {

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

var handle_get = function (req, res, next) {
    console.log( "Get: ..." ) ;
    ts = new Date().getTime()
    console.log( ts )
    state = "no-coin" ;
    page( req, res, state, ts ) ;
}


/*  Handlebars Test using Home template 

app.get('/', function (req, res, next) {
    res.render('home', {
        showTitle: true,
        helpers: {
            foo: function () { return 'foo!'; },
            bar: function () { return 'bar!'; }
        }
    });
});

*/

app.get('/', handle_get ) ;
app.post('/', handle_post ) ;

db_init(function (err, results) {
    if (err) {
        console.error("FATAL ERROR INIT:");
        console.error(err);
        process.exit(-1);
    } else {
        console.log( "Server running on Port 8080..." ) ;
        //db.collections(function(err, collections) {
        //    console.log(collections);
        //});
        app.listen(8080);
    }
});



/**

Mighty Gumball, Inc.

NodeJS-Enabled Standing Gumball
Model# M102988
Serial# 1234998871109

-- MongoDB (Mongo Labs) Connection

Host:   ds043220.mongolab.com
Port:   43220
Login:  user
Passwd: pwd

-- MongoDB (Localhost) Connection

Host:   localhost
Port:   27017

-- Add Mongodb Admin User

See:  https://docs.mongodb.com/manual/tutorial/enable-authentication/

use admin
db.addUser('cmpe281', 'cmpe281');

use test
db.runCommand( { createUser: "accountAdmin01",
                 pwd: "cleartext password",
                 roles: [
                           { role: "clusterAdmin", db: "admin" },
                           { role: "readWriteAnyDatabase", db: "admin" },
                             "readWrite"
                        ],
                 writeConcern: { w: "majority" , wtimeout: 5000 }
                } )
                

-- Gumball MongoDB Collection (Create Document)

db.gumball.insert(
{ 
  id: 1,
  countGumballs: 8,
  modelNumber: 'M102988',
  serialNumber: '1234998871109' 
}
) ;

-- Gumball MongoDB Collection - Find Gumball Document

db.gumball.find( { id: 1 } ) ;

**/


