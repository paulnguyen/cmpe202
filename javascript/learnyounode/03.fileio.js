/*

https://nodejs.org/api/fs.html
https://nodejs.org/api/buffer.html

https://nodejs.org/dist/latest-v5.x/docs/api/fs.html
https://nodejs.org/dist/latest-v5.x/docs/api/buffer.html

node 03.fileio.js 01.hello.js 

> 12

*/

var fs = require('fs') 
var buf = fs.readFileSync(process.argv[2])
var str = buf.toString()
console.log(str.split("\n").length-1) 
