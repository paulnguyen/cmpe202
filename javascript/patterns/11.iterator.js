
/*

	http://www.dofactory.com/javascript/iterator-design-pattern

	Iterator

	Provide a way to access the elements of an aggregate object sequentially
	without exposing its underlying representation.

*/

function alert(msg) {
	console.log(msg)
}

var Iterator = function(items) {
    this.index = 0;
    this.items = items;
}
 
Iterator.prototype = {
    first: function() {
        this.reset();
        return this.next();
    },
    next: function() {
        return this.items[this.index++];
    },
    hasNext: function() {
        return this.index <= this.items.length;
    },
    reset: function() {
        this.index = 0;
    },
    each: function(callback) {
        for (var item = this.first(); this.hasNext(); item = this.next()) {
            callback(item);
        }
    }
}
 
// log helper
 
var log = (function() {
    var log = "";
    return {
        add: function(msg) { log += msg + "\n"; },
        show: function() { alert(log); log = ""; }
    }
})();
 
function run() {
    var items = ["one", 2, "circle", true, "Applepie"];
    var iter = new Iterator(items);
 
    // using for loop
 
    for (var item = iter.first(); iter.hasNext(); item = iter.next()) {
        log.add(item);
    }
    log.add("");
 
    // using Iterator's each method
 
    iter.each(function(item) {
        log.add(item);
    });
 
    log.show();
}

run()
