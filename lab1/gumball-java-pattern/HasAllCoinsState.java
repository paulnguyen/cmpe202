/**
 * Release gumble and reset machine 3 to get new coins.
 *
 * @author Chi Tran
 * @version Feb-08-2019
 */
public class HasAllCoinsState implements State
{
    GumballMachine3 gumballMachine3;
 
    public HasAllCoinsState(GumballMachine3 gumballMachine3) {
        this.gumballMachine3 = gumballMachine3;
    }
  
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
 
    public void ejectQuarter() {
        System.out.println("Quarter returned");
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine3.setState(gumballMachine3.getSoldState());
    }
    
    public void insertCoin(int coin) {
        System.out.println("You can't insert another coin");
    }
 
    /**
     * Eject quarter and reset machine
     */
    public void ejectCoin() {
        System.out.println("Coins returned");
        gumballMachine3.setState(gumballMachine3.getNoAllCoinsState());
    }
    
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
