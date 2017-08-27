
//  https://github.com/senchalabs/connect#middleware
//  https://github.com/expressjs/body-parser
//
//  npm install (package.json)

var express = require('express');
var app = express();
var bodyParser = require('body-parser');

var urlencodedParser = bodyParser.urlencoded({ extended: false })

var handle_post = function (req, res) {
    res.end("Hello There! " +  req.body.hello + "\n");
}

var handle_get = function (req, res) {
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);
    res.end("<html><body><form action='/' method='post'><input type='text' name='hello'><input type='submit'></form></body></html>");
}

app.post("*", urlencodedParser, handle_post );
app.get( "*", handle_get ) ;

app.listen(8080);