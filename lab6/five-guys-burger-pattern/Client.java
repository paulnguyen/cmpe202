  

public class Client {

    public static void runTest()
    {
        Component theOrder = BuildOrder.getOrder() ;
        theOrder.printDescription();
        
        Component returnOrder = ReturnOrder.getOrder() ;
        returnOrder.printDescription();
    }
}
 
