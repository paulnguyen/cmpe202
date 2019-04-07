public class GumballMachine {

	private int cnt = 0;
	private boolean quarterInSlot = false;
	private int coinValue = 0;

	public String getTenant() {
		return null ;
	}
	
	public int getCoinValue() {
		return coinValue;
	}

	public void setCoinValue(int v) {
		this.coinValue = v;
	}

	public boolean isQuarterInSlot() {
		return quarterInSlot;
	}

	public void setQuarterInSlot(boolean q) {
		this.quarterInSlot = q;
	}

	public GumballMachine(int count) {
		this.cnt = count;
	}

	public void insertQuarter() {
		System.out.println( "==> Insert Quarter <==" ) ;
	}

	public void insertCoin(Integer value) {
		System.out.println( "==> Insert Coin " + value.toString() + " <==" ) ;
	}

	public void turnTheCrank() {
		System.out.println( "==> Turn Crank <==" ) ;
	}

	public int getCount() {
		return cnt;
	}

	public void setCount(int c) {
		cnt = c;
	}

	public static void main(String[] args) {
		GumballMachine m = new GumballMachine(2);
		System.out.println("*** Gumball Machine " + m.getTenant() + " *** ");
		m.insertQuarter();
		m.turnTheCrank(); // should eject for tenant #1
		m.insertQuarter();
		m.turnTheCrank(); // should eject for tenant #1, #2, and #3
		m.insertCoin(10);
		m.insertCoin(10);
		m.insertCoin(5);
		m.insertCoin(25);
		m.turnTheCrank(); // should eject for tenant #3
		m.insertCoin(10);
		m.insertCoin(10);
		m.turnTheCrank(); // should eject for tenant #3
	}

}
