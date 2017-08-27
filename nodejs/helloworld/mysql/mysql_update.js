/*

https://github.com/felixge/node-mysql

npm install mysql

*/

var mysql = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'paulnguyen',
  password : '',
  database : 'CMPE281'
});

connection.connect();

connection.query( 'UPDATE gumball set count_gumballs = ? where id = ?', [1001, 1], 
	function(err, rows, fields) {
  		if (err) throw err;
  		console.log('changed ' + rows.changedRows + ' rows');
	}
);

connection.end();