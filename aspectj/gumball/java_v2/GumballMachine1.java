
import java.lang.reflect.* ;

public class GumballMachine1 extends GumballMachine implements IGumballMachineCrank
{

    public GumballMachine1(int count)
    {
        super(count) ;
        setCost(25) ;
    }

    public void insertQuarter()
    {
        System.out.println("=> Insert Quarter...") ;
        insertCoinValue( 25 ) ;  
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
        GumballMachine1 m = new GumballMachine1(10) ;
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
