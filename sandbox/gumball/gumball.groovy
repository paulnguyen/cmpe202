
import groovy.json.* ;

class GumballMachine {
	
	// groovy generates set/get for properties 
	String model  = "M1V192019"
	String serial = "123997919189"
	Integer count = 100
	Integer coinValue = 0 ; // cents
	Integer cost = 0 ; // configure at setup	

	// update value of coins inserted
	private void insert( int value ) { 
		def newValue = coinValue + value
		println( "${newValue} > ${cost}?")
		if ( newValue > cost ) {
			println( "There's already enough money!" ) ;
		}
		else {
			coinValue = newValue ;
		}
	}	

	// eject gumball
	private void eject() {
		if ( coinValue < cost ) {
			println( "Not Enough Money!" ) ;
			return ;
		}
		if ( count > 0 ) {
			count-- ;
			println( "Gumball Ejected!" ) ;
			println( "Change Return: " + (coinValue - cost) + " cents." ) ;
			coinValue = 0 ;
		}
		else {
			println( "Sorry! Out of Gumballs." ) ;
		}
	}

	// catch-all method calls
	def methodMissing( String name, def args) {
		println( "${name}(${args})")
        if ( name == "setCrankModel" ) {
        	println ( "Crank Model - ${args[0]} cents" )
        	this.cost = args[0]
        }   
        else if ( name == "setSlotModel" ) {
        	println ( "Slot Model - ${args[0]} cents" )
        	this.cost = args[0]
        }     
        else if ( name == "insertQuarter" ) {
        	insert( 25 )
        }   
        else if ( name == "turnTheCrank" ) {
        	eject() 
        }     
        else if ( name == "insertCoin" ) {
       	 	coinValue += args[0] 
			if (coinValue >= cost)
				eject()        	
        	}   
        else if ( name == "returnCoins" ) {
			println( "Change Return: " + coinValue  + " cents." ) ;
			coinValue = 0
        }     
        else {
        	println( "Method Not Found: ${name}")
        }   
   	}

	// main
	static void main(String[] args) {

		GumballMachine m = new GumballMachine()
		println ( "${m.model} ${m.serial} ${m.count}" )

		println( "=== CRANK MODEL ===")
		m.setCrankModel(25)
		println ( new JsonBuilder(m).toPrettyString() )
		m.insertQuarter()
		println ( new JsonBuilder(m).toPrettyString() )
		m.insertQuarter()
		println ( new JsonBuilder(m).toPrettyString() )
		m.turnTheCrank()
		println ( new JsonBuilder(m).toPrettyString() )

		println( "=== SLOT MODEL ===" )
		m.setSlotModel(50)
		println ( new JsonBuilder(m).toPrettyString() )
		m.insertCoin(25)
		println ( new JsonBuilder(m).toPrettyString() )
		m.insertCoin(100)
		println ( new JsonBuilder(m).toPrettyString() )

	}

}


