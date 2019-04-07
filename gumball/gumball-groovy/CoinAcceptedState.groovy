package gumball

class CoinAcceptedState implements IGumballState {
	
	def GumballMachine context ;

	def CoinAcceptedState(GumballMachine m) {
		context = m
	}
	
	def insertCoin() {
		context.setHasCoin()
	}
	
	def crankHandle() {
		context.setNoCoin()
	}
}
