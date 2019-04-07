
import java.lang.reflect.* ;

public class GumballMachine implements IGumballMachine {

	private 		int cnt = 0; // inventory
	private 		int coinValue = 0 ; // cents
	private 		int cost = 0 ; // configure at setup

	public GumballMachine() {
		this.cnt = 100 ;
		setCost(50) ;
	}

	public GumballMachine(int count) {
		this.cnt = count;
		setCost(50) ;
	}

	// Display Config
	public void dumpConfig() {
		System.out.println( "Gumball Inventory: " + cnt ) ;
		System.out.println( "Gumball Cost:      " + cost ) ;
		System.out.println( "Coin Value:        " + coinValue ) ;
	}
	
	// Configure Cost of a Gumball
	private void setCost( int c ) { cost = c ; }
	public int getCost() { return cost ; }

	// Coin Property
	private void setCoinValue( int v ) { 
		if ( (coinValue) > cost ) {
			System.out.println( "There's already enough money!" ) ;
		}
		else {
			coinValue = v ;
			if ( coinValue >= cost )
				ejectGumball() ;
		}
	}
	private int  getCoinValue() { return coinValue ; }
	
	
	// Insert Coin Helper Method
	public void insertCoinValue( int v ) {
		System.out.println( "Added " + v + " cents...") ;
		setCoinValue(coinValue + v) ;
	}
	
	// Eject Gumball if Available
	private void ejectGumball() {
		if ( coinValue < cost ) {
			System.out.println( "Not Enough Money!" ) ;
			return ;
		}
		if ( cnt > 0 ) {
			cnt-- ;
			System.out.println( "Gumball Ejected!" ) ;
			System.out.println( "Change Return: " + (coinValue - cost) + " cents." ) ;
			coinValue = 0 ;
		}
		else {
			System.out.println( "Sorry! Out of Gumballs." ) ;
		}
	}
	
	
}
