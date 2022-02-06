

public class NoCoinsState implements State {
    GumballMachine gumballMachine;
 
    public NoCoinsState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int value) {
		gumballMachine.addCoinValue(value) ;
		System.out.println( "Added " + value + " cents...") ;
		gumballMachine.setHasCoinsState() ;
	}
 
	public void ejectCoins() {
		System.out.println("You haven't inserted any coins");
	}
 
	public void purchase() {
		System.out.println("There are no coins to make purchase!");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "Waiting for coin";
	}
}
