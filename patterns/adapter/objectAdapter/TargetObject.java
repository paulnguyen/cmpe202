package adapter.objectAdapter;

public class TargetObject implements Target {
 
	private AdapteeObject adaptee;
    
    public TargetObject()
    {
        adaptee = new AdapteeObject() ;
    }
	 
	/**
	 * @see adapter.objectAdapter.Target#sayHello()
	 */
	public void sayHello() {
	    adaptee.printMessage("Hello");
	}
	 
}
 


