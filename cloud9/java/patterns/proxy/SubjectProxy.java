package proxy;

public interface SubjectProxy {
 
	public abstract String readData(String authToken) throws Exception ;
	public abstract void writeData(String authToken, String data) throws Exception ;
}
 
