import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    Message m = new Message() ;
    private final String service_url = "http://localhost:8080/restlet/hello" ;

    // Cloud 9      - REST Service: http://cloud-paulnguyen.c9users.io:8080/restlet/hello
    // Local        - REST Service: http://localhost:8080/restlet/hello
    // Docker AWS   - REST Service: http://aws.nguyenresearch.com/restlet/hello
    // Docker CLOUD - REST Service: http://restapi-1.df4aed9e.cont.dockerapp.io/restlet/hello

    public Alien()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 180 ) ; 
    }

    protected void setMessage( String msg ) 
    {
        int x, y ;
        x = getX() + 10;  
        y = getY() + 10;  
        World world = getWorld();
        if ( m.getWorld() != null )
        {
            world.removeObject( m ) ;
        }
        world.addObject( m, x, y ) ;
        m.setText( msg ) ;        
    }    
    
      public void act() 
    {
        if(Greenfoot.mousePressed(this)) {        
            try {
                    ClientResource helloClientresource = new ClientResource( service_url ); 
                    Representation result = helloClientresource.get() ; 
                    setMessage( result.getText() ) ;  ; 
            } catch ( Exception e ) {
                 setMessage( e.getMessage() ) ;
            }   
        }
    }    
    
}
