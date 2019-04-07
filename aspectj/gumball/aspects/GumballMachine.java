
import java.lang.reflect.* ;
import java.util.* ;

public class GumballMachine {

	private int cnt = 0; // inventory
	private int coinValue = 0 ; // cents
	private int cost = 0 ; // configure at setup

	public GumballMachine(int count) {
		this.cnt = count;
	}

	// Display Config
	public void dumpConfig() {
		System.out.println( "Gumball Inventory: " + cnt ) ;
		System.out.println( "Gumball Cost:      " + cost ) ;
		System.out.println( "Coin Value:        " + coinValue ) ;
	}
	
	// Coin Property
	private void setCoinValue( int v ) { 
		if ( (coinValue) > cost ) {
			System.out.println( "There's already enough money!" ) ;
		}
		else {
			coinValue = v ;
		}
	}
	private int  getCoinValue() { return coinValue ; }
	
	// Configure Cost of a Gumball
	private void setCost( int c ) { cost = c ; }
	private int getCost() { return cost ; }
	
	
	// Insert Coin Helper Method
	private void insertCoinValue( int v ) {
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
	
	// Main Class - Dump Metadata
	public static void main( String args[ ] )
	{

		System.out.println( "\n\n***** Class Bytecode Dump *****" ) ;
		GumballMachine m = new GumballMachine(10) ;
		Class gmClass = m.getClass() ;

        System.out.println( "\nFIELDS:" ) ;
        Field[] fields = gmClass.getDeclaredFields();
        for (Field f : fields) {

        	int mods = f.getModifiers();
 
        	if ( Modifier.isPublic(mods) )
        		System.out.format( "  public" ) ;
        	else if ( Modifier.isPrivate(mods) )
        		System.out.format( "  private" ) ;
        	else if ( Modifier.isProtected(mods) )
        		System.out.format( "  protected" ) ;
 
        	if ( Modifier.isStatic(mods) )
        		System.out.format( " static") ;

        	System.out.format( " %s %s\n", f.getType(), f.getName() ) ;

        }

        System.out.println( "\nMETHODS:" ) ;
        Method gmMethods[] = gmClass.getMethods() ;
        for ( int i=0; i <gmMethods.length; i++ )
        {
            Method theMethod = gmMethods[i] ;
            String method = theMethod.toString() ;
            System.out.format( "  %s\n", method ) ;
        }

      	System.out.println( "\nINTERFACES:" ) ;
        Type[] intfs = gmClass.getGenericInterfaces();
        if (intfs.length != 0) {
        for (Type intf : intfs)
            System.out.format("  %s%n", intf.toString());
        System.out.format("%n");
        } else {
            System.out.format("  -- No Implemented Interfaces --%n%n");
        }

        System.out.println( "\nEXTENDS:" ) ;
        List<Class> l = new ArrayList<Class>();
        printAncestor(gmClass, l);
        if (l.size() != 0) {
        for (Class<?> cl : l)
            System.out.format("  %s%n", cl.getCanonicalName());
        System.out.format("%n");
        } else {
            System.out.format("  -- No Super Classes --%n%n");
        }        
		
	}

	private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }
	
}
