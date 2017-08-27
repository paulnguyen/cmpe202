
// web_form.js
// Example from: http://stackoverflow.com/questions/17762188/simple-form-node-js-application
//

var http = require('http'); 
var util = require('util');

// Create a function to handle every HTTP request

function handler(req, res){
  
  if(req.method == "GET"){ 
    console.log('get');
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);
    res.end("<html><body><form action='/' method='post'><input type='text' name='hello'><input type='submit'></form></body></html>");
  } 
  else if(req.method == 'POST'){
    console.log('post');
    var hello = 'world';
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);
    res.end("<html><body><h1>Hello "+hello+"!</h1></body></html>");
  } else {
    res.writeHead(200);
    res.end();
  };
};


http.createServer(handler).listen(process.env.PORT, process.env.IP, function(err){
  if(err){
    console.log('Error starting http server');
  } else {
    console.log('Server ' + process.env.IP + ' listening on port ' + process.env.PORT);
  };
});