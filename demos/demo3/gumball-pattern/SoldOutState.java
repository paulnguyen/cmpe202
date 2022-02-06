

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int value) {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
 
	public void ejectCoins() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
 
	public void purchase() {
		System.out.println("You turned, but there are no gumballs");
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
 
	public String toString() {
		return "Sold out";
	}
}
