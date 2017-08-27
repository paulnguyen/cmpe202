
/**

Mighty Gumball, Inc.
Version 6.0

- Variant of Version 4.0 using MongoDB & Mongoose
- Added REST API Service on top of Mongoose

NodeJS-Enabled Standing Gumball
Model# M102988
Serial# 1234998871109

**/

/**
// gumball v6: 
// Mongoose
// http://mongoosejs.com/
// Chance module for random generators
// http://chancejs.com
**/

var fs = require('fs');
var express = require('express');
var app = express();
var mongoose = require('mongoose');
var chance = require('chance').Chance();


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


/* DB Connection */
// var dburi = "mongodb://"+db_user+":"+db_pwd+"@"+db_host+":"+db_port+"/"+db_name+""
var dburi = "mongodb://"+db_host+":"+db_port+"/"+db_name+""
mongoose.connect( dburi );


/* Data Model */
var Schema = mongoose.Schema;
var OrderSchema = new Schema({
  OrdNum:  String,   /* 120981, Etc... */
  OrdStatus: String  /* Backorder, Submitted, Shipped, Etc... */
});   

var GumballOrder = mongoose.model('GumballOrder', OrderSchema);


var handle_get = function (req, res, next) {

    var orderid = req.params.orderid ;
    console.log( "GET: \n" + orderid ) ;
    GumballOrder.findOne( { OrdNum : orderid }, function (err, order) {
        console.log( order ) ;    
        res.writeHead(200, {"Content-Type": "application/json"});
        var output = { orderid: order.OrdNum, status: order.OrdStatus };
        res.end(JSON.stringify(output) + "\n");
    }) ;

}


var handle_post = function (req, res, next) {

    var num = chance.natural().toString();
    var order = new GumballOrder( { OrdNum: num, OrdStatus: 'Submitted' } );
    order.save(function (err) {
        if (err)
        console.log('Save Error:' + err);
    }) ;
    console.log( "POST: \n" + order ) ;
    res.writeHead(200, {"Content-Type": "application/json"});
    res.end(JSON.stringify(order) + "\n");
  
}


app.get(  '/gumball/:orderid', handle_get ) ;
app.post( '/gumball', handle_post ) ;

console.log( "Server running on Port 8080..." ) ;

app.listen(8080);



/**

-- Test REST API

curl -X POST https://cloud-paulnguyen.c9users.io/gumball
curl -X GET https://cloud-paulnguyen.c9users.io/gumball/<ordnum>

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


** Gumball Machine Inventory **

db.gumball.find()

{
    "_id" : ObjectId("54741c01fa0bd1f1cdf71312"),
    "id" : 1,
    "countGumballs" : 8,
    "modelNumber" : "M102988",
    "serialNumber" : "1234998871109"
}

db.gumball.update( 
    { id: 1 }, 
    { $set : { countGumballs : 10 } },
    { multi : false } 
)

** Gumball Orders **

db.gumballorders.insert( { OrdNum: '6447451112210432', OrdStatus: 'Submitted', } )

db.gumballorders.insert( 
	{ 	OrdNum: '6447451112210432',
  		OrdStatus: 'Submitted',
	}
)

db.gumballorders.find(
	{
    	"_id" : ObjectId("55439cea302ed2c804b0fe10")
	}
)

db.gumballorders.find(
	{
    	"OrdNum" : "6737166575075328"
	}
)

db.gumballorders.find()

{
    "_id" : ObjectId("547d6512365294180dd1d365"),
    "OrdNum" : "5222465777172480",
    "OrdStatus" : "Backorder",
    "__v" : 0
}

{
    "_id" : ObjectId("547d65544fc50d1b0d7c864a"),
    "OrdNum" : "5843778627698688",
    "OrdStatus" : "Backorder",
    "__v" : 0
}

{
    "_id" : ObjectId("547d6a3c98a4a4240ddc0f11"),
    "OrdNum" : "7209957814435840",
    "OrdStatus" : "Submitted",
    "__v" : 0
}

{
    "_id" : ObjectId("547d6a4198a4a4240ddc0f12"),
    "OrdNum" : "5343800146788352",
    "OrdStatus" : "Submitted",
    "__v" : 0
}


** Stored MongoDB JavaScript Function
** http://docs.mongodb.org/manual/tutorial/store-javascript-function-on-server/


function processGumballOrders() {
    gm = db.gumball.find( { id : 1 } ) ;
    cnt = gm.next().countGumballs ;
    print( "Current Inventory: " + cnt ) ;
    cursor = db.gumballorders.find( { OrdStatus: { $ne: "Shipped" } } );
    cursor.snapshot() ; // force read isolation
    while ( cursor.hasNext() ) {
        order = cursor.next() ;        
        printjson( order );
        if ( cnt > 0 ) {
            cnt-- ;
            db.gumballorders.update( 
                { _id: order._id }, 
                { $set : { OrdStatus : "Shipped" } },
                { multi : false } 
            );
        }
        else {
            db.gumballorders.update( 
                { _id: order._id }, 
                { $set : { OrdStatus : "Backorder" } },
                { multi : false } 
            );
        }
    }   
    db.gumball.update ( 
        { id: 1 }, 
        { $set : { countGumballs : cnt } },
        { multi : false } 
    )
}

processGumballOrders() ;


**/

