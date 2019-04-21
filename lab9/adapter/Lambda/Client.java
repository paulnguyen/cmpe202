 

public class Client {

    public void runTest()
    {
        Adaptee adaptee = (String msg) -> System.out.println (msg);
        Target target = () -> adaptee.printMessage("Hello");
        target.sayHello() ;
    }

    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runTest() ;
    }
    
 
}



 
