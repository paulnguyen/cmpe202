
/**
 * Accept quarters.
 *
 * @author Chi Tran
 * @version Feb-08-2019
 */
public class NoDoubleQuarterState implements State
{
   GumballMachine2 gumballMachine2;
   int count = 0;
 
    public NoDoubleQuarterState(GumballMachine2 gumballMachine2) {
        this.gumballMachine2 = gumballMachine2;
    }
 
        /**
         * Get quarter and count total number of quarter to change to the next state
         */
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		count = count + 1;
		if (count == 2)
		gumballMachine2.setState(gumballMachine2.getHasDoubleQuarterState());
		else 
		System.out.println("Please insert 2 quaters");
	}
 
	public void ejectQuarter() {
		System.out.println("You haven't inserted 2 quarters");
	}
 
	public void insertCoin(int coin) {
		System.out.println("You have inserted " + coin);
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted any coins");
	}
	
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
}
