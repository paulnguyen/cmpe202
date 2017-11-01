
/*

	https://www.safaribooksonline.com/library/view/mastering-javascript-design

	Filters and pipes

	If you're at all familiar with the Unix command line or, to a lesser
	extent, the Windows command line, then you'll have probably made use of
	pipes. A pipe, which is represented by the | character is shorthand for
	"take the output of program A and put it into program B".

	ls|sort|grep "^[gb].*f$"

*/


// We would like to provide a function that performs a match against each
// member of the array and returns a set of results:


Array.prototype.where = function (inclusionTest) {
  let results = [];
  for (let i = 0; i<this.length; i++) {
    if (inclusionTest(this[i]))
      results.push(this[i]);
  }
  return results;
};


var items = [1,2,3,4,5,6,7,8,9,10];

console.log( 
	items.where(
		function(thing){ return thing % 2 ==0; }
	)
)

// What we return is also an object, an array object in this case. We can
// continue to chain methods onto it like the following:

console.log( 
	items.where(function(thing){ return thing % 2 ==0;})
  		 .where(function(thing){ return thing % 3 == 0;})
 )


// If we add another function to our library of array extensions, we can start
// to see how useful these pipes can be:

Array.prototype.select=function(projection){
  let results = [];
  for(let i = 0; i<this.length;i++){
    results.push(projection(this[i]));
  }
  return results;
};


// This extension allows for projections of the original items based on an
// arbitrary projection function. Given a set of objects which contain IDs and
// names, we can use our fluent extensions to array to perform complex
// operations:

let children = [
	{ id: 1, Name: "Rob" },
	{ id: 2, Name: "Sansa" },
	{ id: 3, Name: "Arya" },
	{ id: 4, Name: "Brandon" },
	{ id: 5, Name: "Rickon" }
];

let filteredChildren = 
	children.where(	 function (x) { return x.id % 2 == 0;})
			.select( function (x) { return x.Name; }) ;

console.log( filteredChildren ) ;





