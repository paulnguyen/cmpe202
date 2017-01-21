package chain_of_responsibility;

public class Client {
    
    public void runTest()
    {
        Handler h1 = new ConcreteHandler1() ;
        Handler h2 = new ConcreteHandler2() ;
        Handler h3 = new ConcreteHandler3() ;

        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        
        System.out.println( "Sending R2...");
        h1.handleRequest("R2");
        System.out.println( "Sending R3...");
        h1.handleRequest("R3");
        System.out.println( "Sending R1...");
        h1.handleRequest("R1");
        System.out.println( "Sending RX...");
        h1.handleRequest("RX");

    }
    
    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }
    

}
