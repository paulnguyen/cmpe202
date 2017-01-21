package mailserver ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;

public class MailServerResource extends ServerResource {

    @Get
    public Representation get() throws JSONException {
       JSONObject mail = new JSONObject() ;
       mail.put( "status", "Received" ) ;
       mail.put( "subject", "RE: Message to Self" ) ;
       mail.put( "content", "Hello There!" ) ;
       return new JsonRepresentation ( mail ) ;
    }

    @Put
    public void put(JsonRepresentation mailRep) {
        JSONObject mail = mailRep.getJsonObject() ;
        System.out.println( "status: " + mail.getString("status")) ;
        System.out.println( "subject: " + mail.getString("subject")) ;
        System.out.println( "content: " + mail.getString("content")) ;
    }
}
