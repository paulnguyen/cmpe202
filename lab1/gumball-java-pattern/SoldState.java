

public class SoldState implements State {
 
    GumballMachine gumballMachine;
    GumballMachine2 gumballMachine2;
    GumballMachine3 gumballMachine3;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
  
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
	
	 public void insertCoin(int coin) {
                System.out.println("Please wait, we're already giving you a gumball");
        }
 
        public void ejectCoin() {
            System.out.println("Sorry, you already turned the crank");
        }
 
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
 
	public void dispense() {
		gumballMachine.releaseBall();
		gumballMachine2.releaseBall();
		gumballMachine3.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
		if (gumballMachine2.getCount() > 0) {
			gumballMachine2.setState(gumballMachine2.getNoDoubleQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine2.setState(gumballMachine2.getSoldOutState());
                }
		if (gumballMachine3.getCount() > 0) {
			gumballMachine3.setState(gumballMachine3.getNoAllCoinsState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine3.setState(gumballMachine3.getSoldOutState());
		}
	}
 
	public String toString() {
		return "dispensing a gumball";
	}
}


