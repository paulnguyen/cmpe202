
/*

	https://www.safaribooksonline.com/library/view/mastering-javascript-design

	Aspect-Oriented Programming (in JavaScript)

	Aspect oriented programming

	Modularity of software is a great feature, the majority of this book has
	been about modularity and its advantages. However, there are some features
	of software that span the entire system. Security is a great example of
	this.

*/

function prototype_chain(object) {
	var proto = object.constructor.prototype,
	    result = 'this';
	while (proto) {
	    result += ' -> ' + proto.constructor.name;
	    proto = Object.getPrototypeOf(proto)
	}
	console.log( result )
}

function prototype_chain_properties(object) {
     if (object == null) return; // recursive approach
     console.log(Object.getOwnPropertyNames(object));
     prototype_chain_properties(Object.getPrototypeOf(object));
}

function prototype_properties( obj ) {
	for (var property in obj.prototype) {
		console.log( property, obj.prototype[property].toString() )
	}
}


// We would like to have similar security code in all the modules of the
// application to check that people are, in fact, authorized to perform some
// action. So if we have a function of the sort

var GoldTransfer1 = (function () {
  function GoldTransfer1() {
  }
  GoldTransfer1.prototype.SendPaymentOfGold = function (amountOfGold, destination) {
    var user = Security.GetCurrentUser();
    if (Security.IsAuthorized(user, "SendPaymentOfGold")) {
      //send actual payment
    } else {
      return { success: 0, message: "Unauthorized" };
    }
  };
  return GoldTransfer1;
})();


/*

	We can see that there is a fair bit of code in place to check if a user is
	authorized. This same boilerplate code is used elsewhere in the
	application. In fact, with this being a high security application, the
	security checks are in place in every public function. All is well until
	we need to make a change to the common security code. This change needs to
	take place in every single public function in the application. We can
	refactor our application all we want, but the truth remains: we need to
	have at least some code in each of the public methods to perform a
	security check. This is known as a cross-cutting concern.

	There are other instances of cross-cutting concerns in most large
	applications. Logging is a great example, as is database access and
	performance instrumenting. Aspect oriented programming (AOP) presents a
	way to minimize the repeated code through a process known as weaving.

*/

class ToWeaveIn {
    BeforeCall() {
        console.log("Before!");
    }
    AfterCall() {
        console.log("After!");
    }
}

var GoldTransfer2 = (function () {
  function GoldTransfer2() {
  }
  GoldTransfer2.prototype.SendPaymentOfGold = function (amountOfGold, destination) {
        /* @aspect(Security) */
        // send actual payment
        console.log("Payment sent");
  };
  return GoldTransfer2;
})();


function weave(toWeave, toWeaveIn, toWeaveInName) {
	console.log(toWeave.prototypeb)
    for (var property in toWeave.prototype) {
        var stringRepresentation = toWeave.prototype[property].toString();
        console.log(stringRepresentation);
        if (stringRepresentation.indexOf("@aspect(" + toWeaveInName + ")") >= 0) {
            toWeave.prototype[property + "_wrapped"] = toWeave.prototype[property];
            toWeave.prototype[property] = function () {
                toWeaveIn.BeforeCall();
                toWeave.prototype[property + "_wrapped"]();
                toWeaveIn.AfterCall();
            };
        }
    }
}

console.log( "===== Prototype Chain for GoldTransfer2 =====")
prototype_chain( GoldTransfer2 )

console.log( "===== Prototype Chain Properties for GoldTransfer2 =====")
prototype_chain_properties( GoldTransfer2 )

console.log( "===== Prototype Properties for GoldTransfer2 (Before Weaving) =====")
prototype_properties( GoldTransfer2 )

weave(GoldTransfer2, new ToWeaveIn(), "Security");

console.log( "===== Prototype Properties for GoldTransfer2 (After Weaving) =====")
prototype_properties( GoldTransfer2 )

console.log( "===== Test SendPaymentOfGold (After Weaving) =====")
obj = new GoldTransfer2()
obj.SendPaymentOfGold(50, "Starks");

