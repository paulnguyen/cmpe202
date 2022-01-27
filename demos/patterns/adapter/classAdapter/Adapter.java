package adapter.classAdapter;

public class Adapter extends AdapteeParent implements Target {
 
	/**
	 * @see adapter.classAdapter.Target#sayHello()
	 */
	public void sayHello() {
	    super.printMessage( "Hello" );
	}
	 
}



