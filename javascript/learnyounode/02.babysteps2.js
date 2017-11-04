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
var sum = 0;

function sum_numbers(e, i, a) {
  //console.log(a) ;
  if (i>=2) sum += Number(e) ;
}

arr.forEach(sum_numbers) ;

console.log(sum) ;
//console.log(process.argv)  ;
