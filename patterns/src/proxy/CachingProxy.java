package proxy;

public class CachingProxy implements SubjectProxy {

    RealSubject subject = new RealSubject();
    String dataCache = null;
    Boolean cacheExpired = false;

    /**
     * @see proxy.SubjectProxy#readData(java.lang.String)
     */
    public String readData(String authToken) throws Exception {
        if (dataCache != null && !cacheExpired) {
            System.out.println("Cache hit! Returning cached data.");
            return dataCache;
        }
        else {
            dataCache = subject.readData();
            cacheExpired = false;
            return dataCache;
        }
    }

    /**
     * @see proxy.SubjectProxy#writeData(java.lang.String, java.lang.String)
     */
    public void writeData(String authToken, String data) throws Exception {
        subject.writeData(data);
        dataCache = data;
        cacheExpired = false;
    }
}
 
