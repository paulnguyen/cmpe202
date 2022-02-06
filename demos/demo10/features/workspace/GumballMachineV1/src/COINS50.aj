
public aspect COINS50 {

	// implement advice for getTenant
	Object around(GumballMachine m) : target(m) && call(String GumballMachine.getTenant(..)) {
		return "COINS50" ;
	}		
	
	// implement advice for insertQuarter
	after(GumballMachine m): target(m) && call(void GumballMachine.insertQuarter(..)) {
		if (m.getCoinValue() < 50) {
			m.setCoinValue(m.getCoinValue() + 25);
			System.out.println("A quarter has been inserted");
		} else {
			System.out.println("There are already quarters in the slot");
		}
	}
	
	
	// implement advice for insertCoin
	after(GumballMachine m): target(m) && call(void GumballMachine.insertCoin(..)) {
		Object[] args = thisJoinPoint.getArgs();
		int value = ((Integer) args[0]).intValue() ;
		if (m.getCoinValue() < 50) {
			m.setCoinValue(m.getCoinValue() + value);
			System.out.println( value + " cents has been inserted");
		} else {
			System.out.println("There are already 50 cents in the slot");
		}
	}

	// implement advice for turnTheCrank
	after(GumballMachine m): target(m) && call(void GumballMachine.turnTheCrank(..)) {
		if (m.getCoinValue() == 50) {
			m.setCoinValue(0);
			if (m.getCount() > 0) {
				System.out.println("Here is your Gumball!  Enjoy!");
				m.setCount(m.getCount() - 1);
			} else {
				System.out.println("Sorry!  We're out of Gumballs!");
			}
		} else {
			System.out.println("Crank will not turn without enough Coins!");
		}
	}	
	
}