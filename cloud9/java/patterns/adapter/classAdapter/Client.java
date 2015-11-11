package adapter.classAdapter;

public class Client {
    
    public void runTest()
    {
        Target obj = new Adapter() ;
        obj.sayHello() ;
    }
 
}


