package helloworld ;

// REF:  http://restlet.com/technical-resources/restlet-framework/guide/2.3/editions/jse/overview

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.data.Protocol;
import org.restlet.Component;

public class HelloWorldServer extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/hello", HelloWorldResource.class);

        return router;
    }
    
    public static void main(String[] args) throws Exception {  
        // Create a new Component.  
        Component component = new Component();  

        // Add a new HTTP server listening on port 8080.  
        component.getServers().add(Protocol.HTTP, 8080);  

        // Attach the sample application.  
        component.getDefaultHost().attach("/restlet",  
            new HelloWorldServer());  

        // Start the component.  
        component.start();  
    }  


}