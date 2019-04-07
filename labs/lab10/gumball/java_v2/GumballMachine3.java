
import java.lang.reflect.* ;

public class GumballMachine3 extends GumballMachine implements IGumballMachineSlot
{
   public GumballMachine3(int count)
    {
        super(count) ;
        setCost(50) ;
    }

    public void insertCoin(int value) {
        System.out.println("=> Insert Coin: " + value + " cents");
        insertCoinValue(value);
        if (coinValue >= cost)
            ejectGumball();
    }

    public void returnCoins() {
        System.out.println("=> Return Coins...");
        System.out.println( "Change Return: " + coinValue  + " cents." ) ;
        setCoinValue( 0 ) ;
    }

    // Main Class - Dump Metadata
    public static void main( String args[ ] )
    {
        System.out.println( "***** Class Bytecode Dump *****" ) ;
        GumballMachine3 m = new GumballMachine3(10) ;
        Class gmClass = m.getClass() ;
        Method gmMethods[] = gmClass.getMethods() ;
        for ( int i=0; i <gmMethods.length; i++ )
        {
            Method theMethod = gmMethods[i] ;
            String method = theMethod.toString() ;
            System.out.println( method ) ;
        }
        
    }    

}
