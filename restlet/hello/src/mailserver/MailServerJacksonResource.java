package mailserver ;

import java.io.IOException;
import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.jackson.* ;
import org.restlet.resource.* ;

public class MailServerJacksonResource extends ServerResource {

    @Get
    public Representation get_request()  {
       Mail mail = new Mail() ; // POJO (just setters and getters)
       mail.setStatus( "received") ;
       mail.setSubject( "Message to Self") ;
       mail.setContent( "Hello There!  From Jackson.") ;
       return new JacksonRepresentation<Mail>(mail) ;
    }

    @Put
    public void put_request(Representation rep) throws IOException {
        JacksonRepresentation<Mail> mailRep = new JacksonRepresentation<Mail> ( rep, Mail.class ) ;
        Mail mail = mailRep.getObject() ;
        System.out.println( "status: " + mail.getStatus() ) ;
        System.out.println( "subject: " + mail.getSubject() ) ;
        System.out.println( "content: " + mail.getContent() ) ;
    }
}
