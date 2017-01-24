package gumball

class HasCoinState implements IGumballState {
	
	def GumballMachine context ;
	
	def HasCoinState(GumballMachine m)
	{
		context = m
	}
	
	def insertCoin()
	{
		println "error: coin already inserted"
	}
	
	def crankHandle()
	{
		context.setCoinAccepted()
	}
}
