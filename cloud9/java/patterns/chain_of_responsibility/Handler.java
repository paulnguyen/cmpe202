package chain_of_responsibility;

public interface Handler {

	void handleRequest( String request );
	void setSuccessor(Handler next);

}
