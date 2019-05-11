
class GumballMachine : IGumballMachineCrank {

	val model  = "M1V192019"
		get() = "Model# ${field}"
	val serial = "123997919189"
		get() = "Serial# ${field}"

	var coinValue : Int = 0
	var cost = 0  // configure at setup	
	var count : Int 

    init {
        count = 100
    }

    fun configCost( theCost : Int ) {
    	cost = theCost
    }

	override fun insert( value : Int ) { 
		var newValue = coinValue + value
		println( "${newValue} > ${cost}?")
		if ( newValue > cost ) {
			println( "There's already enough money!" ) 
		}
		else {
			coinValue = newValue 
		}
	}	

	override fun eject() {
		if ( coinValue < cost ) {
			println( "Not Enough Money!" ) 
			return 
		}
		if ( count > 0 ) {
			count-- 
			println( "Gumball Ejected!" ) 
			println( "Change Return: " + (coinValue - cost) + " cents." ) 
			coinValue = 0 
		}
		else {
			println( "Sorry! Out of Gumballs." ) 
		}
	}
    
	fun debug() {
		println( "${model} ${serial} cnt:${count} value:${coinValue} cost:${cost}" )
	}

}

interface IGumballMachineCrank {

	fun insert( value : Int )
	fun eject()

	fun insertQuarter() { 
		insert( 25 ) 
	}

	fun turnTheCrank() {
		eject()
	}

}

fun GumballMachine.insertCoin( value : Int ) {
	coinValue += value 
	if (coinValue >= cost)
		eject()  
}

fun GumballMachine.returnCoins( ) {
	println( "Change Return: " + coinValue  + " cents." ) ;
	coinValue = 0
}

fun main() {

	var m = GumballMachine()
	m.configCost(50)
	m.debug()

	// Crank Test
	m.insertQuarter()
	m.debug()
	m.turnTheCrank()
	m.debug()
	m.insertQuarter()
	m.debug()
	m.turnTheCrank()
	m.debug()

	// Slot Test 
	m.insertCoin(25)
	m.debug()
	m.insertCoin(100)	
	m.debug()


}
