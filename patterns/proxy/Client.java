package proxy;

public class Client {
    
    private SubjectProxy proxy1 = new AccessProxy() ;
    private SubjectProxy proxy2 = new CachingProxy() ;
    private SubjectProxy proxy3 = new RemotingProxy() ;

    public void runTest() {
        try {
            // read
            System.out.println( proxy1.readData("1234567890") );
            System.out.println( proxy2.readData("1234567890") );
            System.out.println( proxy3.readData("1234567890") );
            // cache hit
            System.out.println( proxy2.readData("1234567890") );
            // write
            proxy1.writeData("1234567890", "New Data");
            proxy2.writeData("1234567890", "New Data");
            proxy3.writeData("1234567890", "New Data");
            // access violation
            proxy1.readData("0000000000");
        }
        catch (Exception e)
        {
            System.out.println( e.getMessage() );
        }
    }
    
   public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }         
    
}
 
