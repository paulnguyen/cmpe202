package proxy;

public class RealSubject {
    
    String theData ;

    public RealSubject()
    {
        theData = "Hello World!" ;
    }

	/**
	 * @see proxy.SubjectProxy#readData(java.lang.String)
	 */
	public String readData() {
		return theData ;
	}
	 
	/**
	 * @see proxy.SubjectProxy#writeData(java.lang.String, java.lang.String)
	 */
	public void writeData(String data) {
	    theData = data ;
	}
	 
}
 
