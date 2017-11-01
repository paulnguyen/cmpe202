
/*

	https://www.safaribooksonline.com/library/view/mastering-javascript-design

	Reactive Programming

	Over the last few years a number of different ideas have arisen in the
	area of treating change as a stream of events – just like the stream that
	Newton supposedly observed. Given a starting position and a stream of
	events it should be possible to figure out the state of the system.
	Indeed, this is the idea behind using an event store. Instead of keeping
	the final state of an aggregate in a database we instead keep track of all
	the events which have been applied to that aggregate.

	REF:

	http://reactivex.io/
	http://reactivex.io/learnrx/
	http://reactivex.io/rxjs/
	http://reactivex.io/rxjs/manual/overview.html
	https://xgrommx.github.io/rx-book/
	https://www.learnrxjs.io/


*/


// Streams - The easiest way to think of an event stream is not to think of
// the streams you've probably used before in programming, input reader
// streams, but to think of arrays. Let's say that you have an array with a
// series of numbers in it:

var arr = [1, 4, 6, 9, 34, 56, 77, 1, 2, 3, 6, 10]

// Now you want to filter this array to only show you even numbers. In modern
// JavaScript this is easily done through the use of the filter function on
// the array:

console.log ( arr.filter( (x)=>x%2==0) )


/* 
	Note: ES6 Syntax:

		var func = (x, y) => { return x + y; };

	This does the same thing as:

		var func = function (x, y) { return x + y; };

*/ 


/*

	http://reactivex.io/rxjs/manual/overview.html

	RxJS is a library for composing asynchronous and event-based programs by
	using observable sequences. It provides one core type, the Observable,
	satellite types (Observer, Schedulers, Subjects) and operators inspired by
	Array#extras (map, filter, reduce, every, etc) to allow handling
	asynchronous events as collections.

	ReactiveX combines the Observer pattern with the Iterator pattern and
	functional programming with collections to fill the need for an ideal way
	of managing sequences of events.

	The essential concepts in RxJS which solve async event management are:

    	- Observable: represents the idea of an invokable collection of future
    	  values or events.

    	- Observer: is a collection of callbacks that knows how to listen to
    	  values delivered by the Observable.
   
    	- Subscription: represents the execution of an Observable, is
    	  primarily useful for cancelling the execution.
    	
    	- Operators: are pure functions that enable a functional programming
    	  style of dealing with collections with operations like map, filter,
    	  concat, flatMap, etc.
    	
    	- Subject: is the equivalent to an EventEmitter, and the only way of
    	  multicasting a value or event to multiple Observers.
    	
    	- Schedulers: are centralized dispatchers to control concurrency,
    	  allowing us to coordinate when computation happens on e.g.
    	  setTimeout or requestAnimationFrame or others.

*/
