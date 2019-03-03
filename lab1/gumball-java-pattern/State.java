

public interface State {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
	public void insertCoin(int coin);
	public void ejectCoin();
}
