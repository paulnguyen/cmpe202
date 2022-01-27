package proxy;

public class RemotingProxy implements SubjectProxy {

    private class HttpClient {
        public String get( String url ) { return "The Remote Data!" ; }
        public void put( String url, String data ) { System.out.println( "Remote Host Update Processed!");}
    }
    // subject is remote!  access will be via HTTP PUT/GET
    HttpClient httpClient = new HttpClient() ;
 
	/**
	 * @see proxy.SubjectProxy#readData(java.lang.String)
	 */
	public String readData(String authToken) throws Exception {
		return httpClient.get( "http://remoteserver/data/id/12345" ) ;
	}
	 
	/**
	 * @see proxy.SubjectProxy#writeData(java.lang.String, java.lang.String)
	 */
	public void writeData(String authToken, String data) throws Exception {
        httpClient.put( "http://remoteserver/data/id/12345", data);
	}
}
 
