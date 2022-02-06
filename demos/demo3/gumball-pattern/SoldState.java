

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
	public void insertCoin(int value) {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	public void ejectCoins() {
		System.out.println("Sorry, purchase is in progress...");
	}
 
	public void purchase() {
		System.out.println("Sorry, purchase is in progress...");
	}
 
	public void dispense() {
		gumballMachine.releaseBall() ;
		int count = gumballMachine.getInventory() ;
		if (count>0) 
			gumballMachine.setNoCoinsState() ;
		else
			gumballMachine.setSoldOutState() ;
	}
 
	public String toString() {
		return "dispensing a gumball";
	}
}


