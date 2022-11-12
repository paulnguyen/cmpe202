
/**

Starbucks Reserved | Cachier's App

**/

// Node.js Environment Settings

//var api_endpoint    =  (process.env.api_endpoint    || "http://localhost:8080/starbucks"    ) ;
var api_endpoint    =  (process.env.api_endpoint    || "http://localhost:8080"              ) ;
var api_key         =  (process.env.api_key         || "2742a237475c4703841a2bf906531eb0"   ) ;
var secret_key      =  (process.env.secret_key      || "kwRg54x2Go9iEdl49jFENRM12Mp711QI"   ) ;
var register_id     =  (process.env.register_id     || "5012349" ) ; // default to Dub-C Store


// Module

var crypto = require('crypto');
var fs = require('fs');
var express = require('express');
var Client = require('node-rest-client').Client; // https://www.npmjs.com/package/node-rest-client

// Startup Express

var app = express();
app.use(express.bodyParser());
app.use("/images", express.static(__dirname + '/images'));
handlebars  = require('express3-handlebars');
hbs = handlebars.create();
app.engine('handlebars', hbs.engine);
app.set('view engine', 'handlebars');


var get_hash = function( state, ts ) {

    // http://nodejs.org/api/crypto.html#crypto_crypto_createhmac_algorithm_key
    text = state + "|" + ts + "|" + secret_key ;
    hmac = crypto.createHmac("sha256", secret_key);
    hmac.setEncoding('base64');
    hmac.write(text);
    hmac.end() ;
    hash = hmac.read();
    console.log( "HASH: " + hash )
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

    console.log( "==> api_endpoint: " + api_endpoint ) ;
    console.log( "==> api_key:      " + api_key ) ;
    console.log( "==> secret_key:   " + secret_key ) ;
    console.log( "==> register_id:  " + register_id ) ;

    res.render('starbucks', {
        state: result.state,
        ts: result.ts,
        hash: result.hash,
        register: register_id,
        message: result.msg
    });

}

// Create our number formatter.
var formatter = new Intl.NumberFormat('en-US', {
  style: 'currency',
  currency: 'USD',
});

var page = function( req, res, ts ) {

    var result = new Object() ;
    var client = new Client();

    var drink = "";
    var milk  = "" ;
    var size  = "" ;
    var status = "" ;
    var total = 0.0 ;

    var args = {
        headers: { "apikey": api_key }
    };

    console.log( "==> api_endpoint: " + api_endpoint ) ;
    console.log( "==> api_key:      " + api_key ) ;
    console.log( "==> secret_key:   " + secret_key ) ;
    console.log( "==> register_id:  " + register_id ) ;

    client.get( api_endpoint + "/order/register/" + register_id, args,
        function(data, response_raw){
            console.log( "** GET **")
            console.log("Current Order for Register " + register_id + ": " + data);
            
            // for(var key in data) {
            //     console.log( "key:" + key + ", value:" + data[key] );
            // }

            var msg =   "\n\nStarbucks Reserved Order\n\n" ;
            
            drink = data.drink ;
            milk  = data.milk  ;
            size  = data.size  ;
            total = data.total ;
            status = data.status ;

            if ( !drink ) {
                console.log( "No Order Found!")
                status = "Ready for New Order" ;
            } else {
                msg = msg +
                    "Drink: " + drink + "\n" +
                    "Milk:  " + milk + "\n" +
                    "Size:  " + size +"\n" +
                    "Total: " + formatter.format(total) +"\n" ;            
            }


            // jsdata = JSON.parse(data)
            // for(var key in jsdata) {
            //     console.log( "key:" + key + ", value:" + jsdata[key] );
            // }                   
            // drink = jsdata.drink ;
            // milk  = jsdata.milk  ;
            // size  = jsdata.size  ;
            // total = jsdata.total ;
            // status = jsdata.status ;


            msg = msg +
                    "\n" +
                    "Register: " + register_id + "\n" +
                    "Status: " + status + "\n" ;

            console.log( "msg = " + msg ) ;

            state = ""
            if ( drink ) {
                state = "has-order" ;    
            } else {
                state = "no-order" ;  
            }
            hash = get_hash ( state, ts ) ;
            console.log( state ) ;
            result.msg = msg ;
            result.ts = ts ;
            result.hash = hash ;
            result.state = state ;

            res.render('starbucks', {
                state: result.state,
                ts: result.ts,
                hash: result.hash,
                message: result.msg,
                register: register_id
            });
    });
}


var order = function( req, res, action, ts, body ) {

    var client = new Client();

    var args = {
        headers: { "apikey": api_key, "Content-Type": "application/json" },
        data: body
    };

    console.log( action )
    if ( action == "new-order" ) {
        // create order
        console.log( "Creating Order...")
        client.post( api_endpoint + "/order/register/" + register_id, args,
            function(data, response_raw) {
                //jsdata = JSON.parse(data)
                console.log( "** POST **")
                console.log(data);
                //for(var key in jsdata) {
                //    console.log( "key:" + key + ", value:" + jsdata[key] );
                //}
                page( req, res, ts ) ;
        });       
    } else if ( action == "clear-order" )  {
        // clear order
        console.log( "Clearing Order...")
        client.delete( api_endpoint + "/order/register/" + register_id, args,
            function(data, response_raw) {
                //jsdata = JSON.parse(data)
                console.log( "** DELETE **")
                console.log(data);
                //for(var key in jsdata) {
                //    console.log( "key:" + key + ", value:" + jsdata[key] );
                //}
                page( req, res, ts ) ;
        });           
    } else {
        // Get Order
        console.log( "Getting Order...")
        page( req, res, ts ) ;
    }

}

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

function getDrink() {
  var num = Math.floor(Math.random() * Math.floor(5));
  return DRINK_OPTIONS[num]
}

function getMilk() {
  var num = Math.floor(Math.random() * Math.floor(5));
  return MILK_OPTIONS[num]
}

function getSize() {
  var num = Math.floor(Math.random() * Math.floor(5));
  return SIZE_OPTIONS[num]
}

var handle_post = function (req, res, next) {

    //console.log( req ) ;
    console.log(    "Post: " + "Action: " +  req.body.event + 
                    " State: " + req.body.state + 
                    " Store: " + req.body.stores + "\n" ) ;
    register_id = req.body.stores ;
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

    if ( diff > 900 || hash1 != hash2 ) {
        error( req, res, "*** SESSION INVALID ***", ts ) ;
    }
    else if ( action == "Place Order" ) {
        action = "new-order" ;
        //hash = get_hash ( state, ts ) ;
        var data = {
            drink : getDrink(),
            milk :  getMilk(),
            size :  getSize()
        } ;
        order(req, res, action, ts, data ) ;   
    }
    else if ( action == "Clear Order" ) {
        action = "clear-order" ;
        //hash = get_hash ( state, ts ) ;
        var data = {}
        order(req, res, action, ts, data ) ;
    } else if ( action == "Get Order" ) {
        action = "get-order" ;
        //hash = get_hash ( state, ts ) ;
        var data = {}
        order(req, res, action, ts, data ) ;
    } else {
        error(req, res, "Invalid Request.", ts ) ;
    }

}

var handle_get = function (req, res, next) {
    console.log( "Get: ..." ) ;
    //console.log( req ) ;
    ts = new Date().getTime() ;
    console.log( ts ) ;
    page( req, res, ts ) ;

}


app.get('/', handle_get ) ;
app.post('/', handle_post ) ;


console.log( "Server running on Port 9090..." ) ;
console.log( "==> api_endpoint: " + api_endpoint ) ;
console.log( "==> api_key:      " + api_key ) ;
console.log( "==> secret_key:   " + secret_key ) ;
console.log( "==> register_id:  " + register_id ) ;


app.listen(9090);

