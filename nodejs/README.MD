     ,-----.,--.                  ,--. ,---.   ,--.,------.  ,------.
    '  .--./|  | ,---. ,--.,--. ,-|  || o   \  |  ||  .-.  \ |  .---'
    |  |    |  || .-. ||  ||  |' .-. |`..'  |  |  ||  |  \  :|  `--, 
    '  '--'\|  |' '-' ''  ''  '\ `-' | .'  /   |  ||  '--'  /|  `---.
     `-----'`--' `---'  `----'  `---'  `--'    `--'`-------' `------'
    ----------------------------------------------------------------- 

## Getting Started with Cloud9

	https://docs.c9.io/docs/
	
## Cloud9 Web Frameworks

    https://docs.c9.io/docs/running-and-debugging-code
    https://docs.c9.io/docs/writing-a-nodejs-app
    https://docs.c9.io/docs/installing-npm-modules

## Support & Documentation

	Visit http://docs.c9.io for support, or to learn more about using Cloud9 IDE. 
	To watch some training videos, visit http://www.youtube.com/user/c9ide

## Cloud9 Workspace Update

	nvm ls
	nvm ls-remote
	nvm install 6.10.0
	nvm use 6.10.0
	nvm alias default 6.10.0 (set defaut for workspace)
	nvm ls
	node -v
	
## Installing Node Packages

	https://docs.npmjs.com/getting-started/installing-npm-packages-locally
	npm install async
	npm install express
	npm install (using package.json)

## A Simple Node.js HTTP Server

	Once you're in Cloud9, create a new file called server.js. Type the following code in the file:

	var http = require('http');
	http.createServer(function (req, res) {
	    res.writeHead(200, {'Content-Type': 'text/plain'});
	    res.end('Hello World\n');
	}).listen(process.env.PORT, process.env.IP);




    
