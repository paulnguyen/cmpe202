
import java.lang.reflect.* ;
import java.util.* ;

public class GumballMachine2 extends GumballMachine implements IGumballMachineCrank
{
   public GumballMachine2(int count)
    {
        super(count) ;
        setCost(50) ;
    }

    public void insertQuarter()
    {
        int val = getCoinValue() ;
        if ( val > 50 ) {
            System.out.println( "Gumball only costs two Quarters!" ) ;
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
        GumballMachine1 m = new GumballMachine1(10) ;
        Class gmClass = m.getClass() ;

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
