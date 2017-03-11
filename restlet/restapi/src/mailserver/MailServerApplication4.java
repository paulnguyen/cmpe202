package mailserver ;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class MailServerApplication4 extends Application {


    public static void main(String[] args) throws Exception {
        Component mailServer = new Component() ;
        mailServer.getServers().add(Protocol.HTTP, 9000) ;
        mailServer.getDefaultHost().attach(new MailServerApplication4()) ;
        mailServer.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach("/mail", MailServerJacksonResource.class);        
        return router;
    }
}
