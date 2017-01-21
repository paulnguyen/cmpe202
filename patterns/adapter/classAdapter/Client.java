package adapter.classAdapter;

public class Client {
    
    public void runTest()
    {
        Target obj = new Adapter() ;
        obj.sayHello() ;
    }
    
    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }
 
}


