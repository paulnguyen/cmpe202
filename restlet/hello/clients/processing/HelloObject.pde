
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;

class HelloObject
{
  private final String service_url = "http://localhost:8080/restlet/hello" ;
  String getMessage() { 
    try {
      ClientResource helloClientresource = new ClientResource( service_url ); 
      Representation result = helloClientresource.get() ; 
      return result.getText() ; 
    } catch ( Exception e ) {
      return e.getMessage() ;
    }   
  }
}

// Cloud 9      - REST Service: http://cloud-paulnguyen.c9users.io:8080/restlet/hello
// Local        - REST Service: http://localhost:8080/restlet/hello
// Docker AWS   - REST Service: http://aws.nguyenresearch.com/restlet/hello
// Docker CLOUD - REST Service: http://restapi-1.df4aed9e.cont.dockerapp.io/restlet/hello