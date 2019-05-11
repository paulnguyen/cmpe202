
class GumballMachine {
    
    var model : String = "M1V192019"
    var serial : String = "123997919189"
	var coinValue : Int = 0
	var cost : Int = 0  // configure at setup	
	var count : Int = 0

    init() {
    	self.count = 100
    }

	func insert( value : Int ) { 
		let newValue = coinValue + value
		print( newValue, " > ", cost, "?")
		if ( newValue > cost ) {
			print( "There's already enough money!" ) 
		}
		else {
			coinValue = newValue 
		}
	}	

	func eject() {
		if ( coinValue < cost ) {
			print( "Not Enough Money!" ) 
			return 
		}
		if ( count > 0 ) {
			count -= 1
			print( "Gumball Ejected!" ) 
			print( "Change Return: ", (coinValue - cost), " cents." ) 
			coinValue = 0 
		}
		else {
			print( "Sorry! Out of Gumballs." ) 
		}
	}

    func configCost( theCost : Int ) {
    	self.cost = theCost
    }
    
    func debug() {
        print( "model:", model, " serial:", serial, " cnt:", count, " value:", coinValue, " cost:", cost )
    }
    
}


/* ============== */
/* CRANK PROTOCOL */
/* ============== */


protocol CrankProtocol {

    func insertQuarter()
    func turnTheCrank()

}

extension GumballMachine: CrankProtocol {

    func insertQuarter() {
    	insert( value: 25 )
    }

    func turnTheCrank() {
    	eject()
    }

}

var m1 = GumballMachine()
m1.configCost( theCost: 50 )
m1.debug()

// Crank Test
m1.insertQuarter()
m1.debug()
m1.turnTheCrank()
m1.debug()
m1.insertQuarter()
m1.debug()
m1.turnTheCrank()
m1.debug()



/* ============== */
/* SLOT  PROTOCOL */
/* ============== */


protocol SlotProtocol {

    func insertCoin( value: Int)
    func returnCoins()

}

extension GumballMachine: SlotProtocol {

    func insertCoin( value: Int ) {
		coinValue += value 
		if (coinValue >= cost) {
			eject()      	
		}
    }

    func returnCoins() {
		print( "Change Return: ", coinValue, " cents." ) ;
		coinValue = 0    	
    }

}

var m2 = GumballMachine()
m2.configCost( theCost: 50 )
m2.debug()

// Slot Test 
m2.insertCoin( value: 25)
m2.debug()
m2.insertCoin( value: 100)	
m2.debug()



