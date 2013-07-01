package singleton;

public class Client {
 
	private Singleton theSingleton;
	 
	public void runTest() {

	    // error - can not instantiate directly
        //theSingleton = new Singleton() ;

        // access the singleton instance
        theSingleton = Singleton.getInstance() ;

	}
	 
}
 
