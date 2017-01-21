

public privileged aspect SLOTMODEL {

	// Declarations
	declare parents: GumballMachine implements IGumballMachineSlot;

	// Insert Quarter Introduction
	public void GumballMachine.insertCoin(int value) {
		System.out.println("=> Insert Coin: " + value + " cents");
		insertCoinValue(value);
		if (coinValue >= cost)
			ejectGumball();
	}

	// Turn Crank Introduction
	public void GumballMachine.returnCoins() {
		System.out.println("=> Return Coins...");
		System.out.println( "Change Return: " + coinValue  + " cents." ) ;
		setCoinValue( 0 ) ;
	}

	// Test
	after() : execution(static * *.main(..) ) {
		System.out.println("\n\n***** Gumball Machine Slot Model 2.0 *****\n\n");
		GumballMachine m = new GumballMachine(10);
		m.dumpConfig();
		m.insertCoin(10) ;
		m.insertCoin(5);
		m.returnCoins();  // return 15 cents change
		m.insertCoin(50) ; // ejects gumball
		m.insertCoin(100) ; // ejects gumball + 50 cents change
		m.insertCoin(25) ;
		m.insertCoin(10) ;
		m.insertCoin(5) ;
		m.insertCoin(10) ; // ejects gumball 
		m.dumpConfig() ;
		
	}	
	
}
