package composite;

public class Client {

    public static void runTest()
    {
        Component theOrder = BuildOrder.getOrder() ;
        theOrder.printDescription();
    }
    
   public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }    
    
}
 
