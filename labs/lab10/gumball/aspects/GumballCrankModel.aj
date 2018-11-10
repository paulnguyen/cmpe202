
public privileged aspect GumballCrankModel {

	// Declarations
	declare parents: GumballMachine implements IGumballMachineCrank;

	// Insert Quarter Introduction
	public void GumballMachine.insertQuarter() {
		System.out.println("=> Insert Quarter...") ;
		insertCoinValue( 25 ) ;
	}
	
	// Turn Crank Introduction	
	public void GumballMachine.turnTheCrank() {
		System.out.println("=> Turn The Crank...") ;
		ejectGumball() ;
	}

	// Test
	after() : execution(static * *.main(..) ) {
		System.out.println( "***** Gumball Machine Crank Model 1.0 *****" ) ;
		GumballMachine m = new GumballMachine(10) ;
		m.dumpConfig() ;
		m.insertQuarter() ;
		m.dumpConfig() ;
		m.turnTheCrank() ;
		m.insertQuarter() ;
		m.dumpConfig() ;
		m.turnTheCrank() ;
		m.insertQuarter() ;
		m.dumpConfig() ;
		m.insertQuarter() ;
		m.dumpConfig() ;
		m.turnTheCrank() ;	
		m.dumpConfig() ;
	}

}

