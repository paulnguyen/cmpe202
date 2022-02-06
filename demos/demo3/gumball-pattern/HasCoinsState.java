

import java.util.Random;

public class HasCoinsState implements State {
	GumballMachine gumballMachine;
 
	public HasCoinsState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin(int value) {
		gumballMachine.addCoinValue(value) ;
		System.out.println( "Added " + value + " cents...") ;
	}
 
	public void ejectCoins() {
		gumballMachine.returnCoins() ;
		gumballMachine.setNoCoinsState() ;
	}
 
	public void purchase() {
		int cost = gumballMachine.getCost() ;
		int value = gumballMachine.getCoinValue() ;
		if ( value >= cost ) {
			gumballMachine.setSoldState() ;
		} else {
			System.out.println("Not enough coins!");
		}
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "Waiting for coin";
	}
}
