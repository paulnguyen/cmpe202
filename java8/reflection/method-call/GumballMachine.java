
import java.lang.reflect.* ;

public class GumballMachine {

	protected int cnt = 0; // inventory
	protected int coinValue = 0 ; // cents
	protected int cost = 0 ; // configure at setup

	private static boolean debug = true ;

	public static ManagedComponent getManagedComponent() {
	    return new ManagedComponent() {
	      public String getClassVersion() {  return "1.0" ; }
     	  public String debugOn() { debug = true ; return "Debug Has Been Turned On."; }
          public String debugOff() { debug = false ; return "Debug Has Been Turned Off."; }
	    } ;
	}

	public GumballMachine(int count) {
		this.cnt = count;
	}

	// Display Config
	public void dumpConfig() {
		if (debug) { 
			System.out.println( "Gumball Inventory: " + cnt ) ;
			System.out.println( "Gumball Cost:      " + cost ) ;
			System.out.println( "Coin Value:        " + coinValue ) ;
		}
	}

	// Coin Property
	protected void setCoinValue( int v ) { 
		if ( (coinValue) > cost ) {
			System.out.println( "There's already enough money!" ) ;
		}
		else {
			coinValue = v ;
		}
	}
	protected int  getCoinValue() { return coinValue ; }
	
	// Configure Cost of a Gumball
	protected void setCost( int c ) { cost = c ; }
	protected int getCost() { return cost ; }
	
	
	// Insert Coin Helper Method
	protected void insertCoinValue( int v ) {
		System.out.println( "Added " + v + " cents...") ;
		setCoinValue(coinValue + v) ;
	}
	
	// Eject Gumball if Available
	protected void ejectGumball() {
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
	
	// Main Class - Dump Metadata
	// 
	public static void main( String args[ ] )
	{

		System.out.println( args[0] ) ;
		try { execute( args[0] ) ; } catch (Exception e) {  System.out.println(e) ; }

		System.out.println( "***** Class Bytecode Dump *****" ) ;
		GumballMachine m = new GumballMachine(10) ;
		m.dumpConfig() ;
		Class gmClass = m.getClass() ;
		Method gmMethods[] = gmClass.getMethods() ;
		for ( int i=0; i <gmMethods.length; i++ )
		{
			Method theMethod = gmMethods[i] ;
			String method = theMethod.toString() ;
			System.out.println( method ) ;
		}
		
	}

	private static void execute( String cmd ) throws Exception {

		Class c = Class.forName( "GumballMachine" ) ;
		Method m = c.getMethod( "getManagedComponent", null ) ;
        ManagedComponent obj =
              (ManagedComponent) m.invoke( null ) ; // class method

        if ( obj != null ) {

          Method mm = null ;
          String result = "" ;
          Class mc = obj.getClass() ; // get class for managed object
          try { mm = mc.getMethod( cmd, null ) ; } catch (Exception e) { System.out.println(e) ; }
          if ( mm != null ) {
            if ( mm.getParameterTypes().length > 0 )
              result = (String) mm.invoke( obj, new Object[] { null } ) ;
            else
              result = (String) mm.invoke( obj, null ) ;
          }

          System.out.println( result ) ;

        }

	}
	
}
