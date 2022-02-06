 
import java.util.ArrayList;

public class Client {

    public static void runTest()
    {
        BuildOrder build = new BuildOrder() ;
        Component theOrder =  build.getOrder() ;
        System.out.println( "===== ORDER RECEIPT ===== " ) ;
        theOrder.doPrint() ;
        System.out.println( "\n\n===== PACKING SLIP ===== " ) ;
        build.doPrintPackingSlip() ;
    }
    
   public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }    
    
}
 
