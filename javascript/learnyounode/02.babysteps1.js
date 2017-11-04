/*

https://nodejs.org/api/process.html
https://nodejs.org/dist/latest-v5.x/docs/api/process.html

node 02.babysteps.js 1 2 3 

> [ '/usr/local/bin/node',
>  '2.babysteps.js',
>  '1',
>  '2',
>  '3' ]


*/


var arr = process.argv
var i = 2;
var len = arr.length;
var sum = 0;

for (; i < len; i++) {
    sum += Number(arr[i]) ;
}

console.log(sum) ;
//console.log(process.argv)  ;
