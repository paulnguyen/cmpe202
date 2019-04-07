package adapter.objectAdapter;

public class Client {

    public void runTest()
    {
        Target obj = new TargetObject() ;
        obj.sayHello() ;
    }

    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }
    
 
}



 
