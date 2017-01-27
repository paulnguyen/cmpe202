package gumball

class CoinRejectedState implements IGumballState {
	
	def GumballMachine context ;
	
	def CoinRejectedState(GumballMachine m)
	{
		context = m
	}
	
	def insertCoin()
	{
		context.setHasCoin()
	}
	
	def crankHandle()
	{
		context.setNoCoin()
	}
	
}
