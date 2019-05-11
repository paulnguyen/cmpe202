
var gm = {
  model: "M1V192019",
  serial: "123997919189",
  coinValue: 0,
  cost: 0,
  count: 100,
  debug: function() {
    console.log(
    	this.model + ' ' + 
    	this.serial + ' ' + 
    	'cnt:' + this.count + ' ' +
    	'value:' + this.coinValue + ' ' + 
    	'cost:' + this.cost 
    );
  },
  insert: function(value) {
   	newValue = this.coinValue + value
   	console.log( newValue + ' > ' + this.cost )
   	if ( newValue > this.cost ) {
   		console.log( "There's already enough money!" )	
   	} else {
   		this.coinValue = newValue 
   	}
  },
  eject: function() {
	if ( this.coinValue < this.cost ) {
		console.log( "Not Enough Money!" ) 
		return 
	}
	if ( this.count > 0 ) {
		this.count-- 
		console.log( "Gumball Ejected!" ) 
		console.log( "Change Return: " + (this.coinValue - this.cost) + " cents." ) 
		this.coinValue = 0 
	}
	else {
		console.log( "Sorry! Out of Gumballs." ) 
	}
  }
} 

gm.debug()

gm.insertQuarter = function() { this.insert( 25 ) }
gm.turnTheCrank = function() { this.eject() }

gm.cost = 50
gm.debug()
gm.insertQuarter()
gm.debug()
gm.insertQuarter()
gm.debug()
gm.turnTheCrank()
gm.debug()


gm.insertCoin = function(value) { 
	this.coinValue += value 
	if (this.coinValue >= this.cost)
		this.eject()  
}

gm.returnCoins = function() { 
	console.log( "Change Return: " + this.coinValue  + " cents." ) ;
	this.coinValue = 0
}

gm.insertCoin(25)
gm.debug()
gm.insertCoin(100)	
gm.debug()

gm.insertCoin(25)
gm.debug()
gm.insertCoin(10)	
gm.debug()
gm.returnCoins()








