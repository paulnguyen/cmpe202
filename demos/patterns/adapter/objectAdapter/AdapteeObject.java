package adapter.objectAdapter;

public class AdapteeObject implements Adaptee {
 
	private TargetObject targetObject;
	 
	/**
	 * @see adapter.objectAdapter.Adaptee#printMessage(java.lang.String)
	 */
	public void printMessage(String msg) {
	    System.out.println( msg ) ;
	}
	 
}
 
