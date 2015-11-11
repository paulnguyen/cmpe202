package proxy;

public class AccessProxy implements SubjectProxy {
    
    RealSubject subject = new RealSubject() ;
 
	/**
	 * @see proxy.SubjectProxy#readData(java.lang.String)
	 */
	public String readData(String authToken) throws Exception {
		if ( authToken.equalsIgnoreCase("1234567890") )
            return subject.readData() ;
        else
            throw new Exception( "Unauthorized Access" ) ;
	}
	 
	/**
	 * @see proxy.SubjectProxy#writeData(java.lang.String, java.lang.String)
	 */
	public void writeData(String authToken, String data) throws Exception {
        if ( authToken.equalsIgnoreCase("1234567890") )
            subject.writeData(data);
        else
            throw new Exception( "Unauthorized Access" ) ;
	}
	 
}
 
