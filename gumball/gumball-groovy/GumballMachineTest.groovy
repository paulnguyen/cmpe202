package gumball;

import org.junit.Test
import static org.junit.Assert.*;

class GumballMachineTest {

	@Test
	def void MainScenario()
	{
		GumballMachine m = new GumballMachine("1234", "1234590ANAG999")
		println m.getAbout()
		assertEquals m.getCurrentState(), "gumball.NoCoinState" 
		m.insertCoin()
		assertEquals m.getCurrentState(), "gumball.HasCoinState"
		m.crankHandle()
		assertEquals m.getCurrentState(), "gumball.CoinAcceptedState"
		m.insertCoin()
		assertEquals m.getCurrentState(), "gumball.HasCoinState"
		
	}
	
}

