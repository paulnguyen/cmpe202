
import java.lang.reflect.* ;

public class GumballMachine2 extends GumballMachine implements IGumballMachineCrank
{
   public GumballMachine2(int count)
    {
        super(count) ;
        setCost(50) ;
    }

    public void insertQuarter()
    {
        System.out.println("=> Insert Quarter...") ;        
        int val = getCoinValue() ;
        if ( val >= 50 ) {
            System.out.println( "Gumball only costs two Quarters!" ) ;
        } else {
            insertCoinValue( 25 ) ;  
        }
        return ; 
    }

    public void turnTheCrank()
    {
        System.out.println("=> Turn The Crank...") ;
        ejectGumball() ;       
    }

    // Main Class - Dump Metadata
    public static void main( String args[ ] )
    {
        System.out.println( "***** Class Bytecode Dump *****" ) ;
        GumballMachine2 m = new GumballMachine2(10) ;
        Class gmClass = m.getClass() ;
        Method gmMethods[] = gmClass.getMethods() ;
        for ( int i=0; i <gmMethods.length; i++ )
        {
            Method theMethod = gmMethods[i] ;
            String method = theMethod.toString() ;
            System.out.println( method ) ;
        }

        GumballMachine2 m2 = new GumballMachine2(10) ;
        m2.insertQuarter() ;
        m2.insertQuarter() ;
        m2.insertQuarter() ;
        m2.turnTheCrank() ;
        
    }    

}
