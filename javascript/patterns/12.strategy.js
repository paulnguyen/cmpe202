
/*

	http://www.dofactory.com/javascript/strategy-design-pattern

	Strategy

	Define a family of algorithms, encapsulate each one, and make them
	interchangeable. Strategy lets the algorithm vary independently from
	clients that use it.

*/

function alert(msg) {
	console.log(msg)
}

var Shipping = function() {
    this.company = "";
};
 
Shipping.prototype = {
    setStrategy: function(company) {
        this.company = company;
    },
 
    calculate: function(package) {
        return this.company.calculate(package);
    }
};
 
var UPS = function() {
    this.calculate = function(package) {
        // calculations...
        return "$45.95";
    }
};
 
var USPS = function() {
    this.calculate = function(package) {
        // calculations...
        return "$39.40";
    }
};
 
var Fedex = function() {
    this.calculate = function(package) {
        // calculations...
        return "$43.20";
    }
};
 
// log helper
 
var log = (function() {
    var log = "";
 
    return {
        add: function(msg) { log += msg + "\n"; },
        show: function() { alert(log); log = ""; }
    }
})();
 
function run() {
    var package = { from: "76712", to: "10012", weigth: "lkg" };
 
    // the 3 strategies
 
    var ups = new UPS();
    var usps = new USPS();
    var fedex = new Fedex();
 
    var shipping = new Shipping();
 
    shipping.setStrategy(ups);
    log.add("UPS Strategy: " + shipping.calculate(package));
    shipping.setStrategy(usps);
    log.add("USPS Strategy: " + shipping.calculate(package));
    shipping.setStrategy(fedex);
    log.add("Fedex Strategy: " + shipping.calculate(package));
 
    log.show();
}

run()
