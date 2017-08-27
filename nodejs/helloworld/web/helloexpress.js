
/*  npm install express */

var express = require('express');
var app = express();

// General Form:  app.method(url regex, optional functions, handler function )

var handler_function = function (req, res) {
    res.end("You asked to see " + req.params.username + "\n");
}

app.all("/user[s]?/:username", handler_function );

app.get("*", function (req, res) {
    res.end("Hello World EXPRESS!\n");
});

app.listen(8080);

// Test with:  curl -X GET -i localhost:8080/users/paul