
/*

	http://www.dofactory.com/javascript/adapter-design-pattern

	Adapter

	Convert the interface of a class into another interface clients expect.
	Adapter lets classes work together that couldn't otherwise because of
	incompatible interfaces.

*/

function alert(msg) {
	console.log(msg)
}

// old interface
 
function Shipping() {
    this.request = function(zipStart, zipEnd, weight) {
        // ...
        return "$49.75";
    }
}
 
// new interface
 
function AdvancedShipping() {
    this.login = function(credentials) { /* ... */ };
    this.setStart = function(start) { /* ... */ };
    this.setDestination = function(destination) { /* ... */ };
    this.calculate = function(weight) { return "$39.50"; };
}
 
// adapter interface
 
function ShippingAdapter(credentials) {
    var shipping = new AdvancedShipping();
 
    shipping.login(credentials);
 
    return {
        request: function(zipStart, zipEnd, weight) {
            shipping.setStart(zipStart);
            shipping.setDestination(zipEnd);
            return shipping.calculate(weight);
        }
    };
}
 
// log helper
 
var log = (function () {
    var log = "";
 
    return {
        add: function (msg) { log += msg + "\n"; },
        show: function () { alert(log); log = ""; }
    }
})();
 
function run() {
    var shipping = new Shipping();
    var credentials = {token: "30a8-6ee1"};
    var adapter = new ShippingAdapter(credentials);
 
    // original shipping object and interface
 
    var cost = shipping.request("78701", "10010", "2 lbs");
    log.add("Old cost: " + cost);
 
    // new shipping object with adapted interface
 
    cost = adapter.request("78701", "10010", "2 lbs");
 
    log.add("New cost: " + cost);
    log.show();
}


run()

