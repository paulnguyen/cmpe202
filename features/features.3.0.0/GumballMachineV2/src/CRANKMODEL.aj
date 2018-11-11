
public privileged aspect CRANKMODEL {

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
			System.out.println( "\n\n***** Gumball Machine Crank Model 2.0 *****\n\n" ) ;
			GumballMachine m = new GumballMachine(10) ;
			m.dumpConfig() ;
			m.insertQuarter() ;
			m.turnTheCrank() ;
			m.insertQuarter() ;
			m.turnTheCrank() ;
			m.insertQuarter() ;
			m.insertQuarter() ;
			m.turnTheCrank() ;
			m.dumpConfig() ;
		}	
	
}
