package gumball ;

class NoCoinState implements IGumballState {
	
	def GumballMachine context ;
	
	def NoCoinState(GumballMachine m)
	{
		context = m 
	}
	
	def insertCoin()
	{
		context.setHasCoin()
	}
	
	def crankHandle()
	{
		println "error: no coin inserted"
	}
}
