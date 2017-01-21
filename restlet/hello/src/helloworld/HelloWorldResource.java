package helloworld ;

// REF:  http://restlet.com/technical-resources/restlet-framework/guide/2.3/editions/jse/overview

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 */
public class HelloWorldResource extends ServerResource {

    @Get
    public String represent() {
        return "hello, world";
    }

}
