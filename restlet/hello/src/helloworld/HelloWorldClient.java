package helloworld ;

// REF:  http://restlet.com/technical-resources/restlet-framework/guide/2.3/editions/jse/overview

import org.restlet.resource.ClientResource;

/**
 * Creates and launches a HTTP client invoking the server listening on port
 * 8080, and writing the response entity on the console.
 */
public class HelloWorldClient {

	// Cloud 9 - REST Service: http://cloud-paulnguyen.c9users.io:8080/restlet/hello
	// Local   - REST Service: http://localhost:8080/restlet/hello

    	private static String service_url = "http://localhost:8080/restlet/hello" ;

    	public static void main(String[] args) throws Exception {
        	ClientResource helloClientresource = new ClientResource( service_url ); 
		helloClientresource.get().write(System.out);
		System.out.println("") ;
    	}
}

