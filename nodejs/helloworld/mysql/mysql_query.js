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

connection.query('SELECT * FROM gumball', 
	function(err, rows, fields) {
  		if (err) throw err;
  		console.log(rows[0]);
	}
);

connection.end();