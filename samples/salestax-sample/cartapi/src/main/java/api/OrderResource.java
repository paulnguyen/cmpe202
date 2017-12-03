package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import org.restlet.ext.jackson.* ;

import java.io.IOException ;

public class OrderResource extends ServerResource {

    @Get
    public Representation get_action() throws JSONException {
        Order order = CartAPI.getOrder() ;
        return new JacksonRepresentation<Order>(order) ;
    }

}



