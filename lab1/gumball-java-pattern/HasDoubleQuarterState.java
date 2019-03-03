
/**
 * Release gumble and reset machine 2 to get new quarter.
 *
 * @author Chi Tran
 * @version Feb-08-2019
 */
public class HasDoubleQuarterState implements State
{
    GumballMachine2 gumballMachine2;
 
    public HasDoubleQuarterState(GumballMachine2 gumballMachine2) {
        this.gumballMachine2 = gumballMachine2;
    }
  
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
 
    /**
     * Eject quarter and reset machine
     */
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine2.setState(gumballMachine2.getNoDoubleQuarterState());
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine2.setState(gumballMachine2.getSoldState());
    }
    
    public void insertCoin(int coin) {
        System.out.println("You can't insert another coin");
    }
 
    public void ejectCoin() {
        System.out.println("No coin to reject");
    }
    
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
		return "waiting for turn of crank";
    }

}
