public aspect QTR25 {

	// implement advice for getTenant
	Object around(GumballMachine m) : target(m) && call(String GumballMachine.getTenant(..)) {
		return "QTR25" ;
	}		

	// implement advice for insertQuarter
	after(GumballMachine m): target(m) && call(void GumballMachine.insertQuarter(..)) {
		if ( !m.isQuarterInSlot() ) {
			m.setQuarterInSlot( true );
			System.out.println("A quarter has been inserted");
		} else {
			System.out.println("There's already a quarter in the slot");
		}
	}

	// implement advice for turnTheCrank
	after(GumballMachine m): target(m) && call(void GumballMachine.turnTheCrank(..)) {
		if (m.isQuarterInSlot()) {
			m.setQuarterInSlot( false ) ;
			if (m.getCount() > 0) {
				System.out.println("Here is your Gumball!  Enjoy!");
				m.setCount(m.getCount()-1);
			} else {
				System.out.println("Sorry!  We're out of Gumballs!");
			}
		} else {
			System.out.println("Crank will not turn without a Quarter!");
		}
	}

}