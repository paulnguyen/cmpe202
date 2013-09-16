/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class Pin {

    private String secretPin = "1234" ;
    private boolean authenticated = false ;
    private static Pin instance ;

    private Pin()
    {
    }

    public static Pin getInstance() {
        if (instance == null) {
            instance = new Pin();
        }
        return instance;
    }

    public boolean isAuthenticated()
    {
        return this.authenticated ;
    }
    
    public void validate( String pinInput ) 
    {
        if ( secretPin.equals(pinInput) )
        {
            this.authenticated = true ;
            System.out.println( "Valid Pin" ) ;
        }
        else
        {
            this.authenticated = false ;
            System.out.println( "Invalid Pin" ) ;
        }
    }
     
}
 
