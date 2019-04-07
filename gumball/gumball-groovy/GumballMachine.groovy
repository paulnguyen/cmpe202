package gumball

class GumballMachine {
	
	def String _model_number
	def String _serial_number
	def IGumballState _current_state 
	
	NoCoinState _no_coin = new NoCoinState(this)
	CoinAcceptedState _coin_accepted = new CoinAcceptedState(this)
	CoinRejectedState _coin_rejected = new CoinRejectedState(this)
	HasCoinState _has_coin = new HasCoinState(this)
	
	GumballMachine(model, serial)
	{
		_current_state = _no_coin
		_model_number = model
		_serial_number = serial
	}
	
	def insertCoin()
	{
		_current_state.insertCoin()
		
	}
	
	def crankHandle()
	{
		_current_state.crankHandle()
	}
	
	def setNoCoin() { _current_state = _no_coin }
	def setCoinAccepted() { _current_state = _coin_accepted }
	def setCoinRejected() { _current_state = _coin_rejected }
	def setHasCoin() { _current_state = _has_coin }
	def String getCurrentState() { return _current_state.getClass().getName() }

	def setCurrentState(state)
	{
		if (state.equals("gumball.NoCoinState")) { setNoCoin() ; }
		if (state.equals("gumball.CoinAcceptedState")) { setCoinAccepted() ; }
		if (state.equals("gumball.CoinRejectedState")) { seCoinRejected() ; }
		if (state.equals("gumball.HasCoinState")) { setHasCoin() ; }
	}

	
def String getAbout() {
		return """
--------------------------------------------------
Mighty Gumball, Inc.
Groovy-Enabled Standing Gumball
Model# ${_model_number}
Serial# ${_serial_number}
--------------------------------------------------
Gumball Machine: ${this.toString()}
Current State: ${_current_state.toString()}
"""		
}
	
}
