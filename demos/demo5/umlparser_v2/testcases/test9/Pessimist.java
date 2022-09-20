
public class Pessimist extends ObserverImpl {

    public Pessimist( SubjectImpl sub )
    {
        super( sub ) ;
    }

    public void update() {
        if ( subject.getState().equalsIgnoreCase("The Price of gas is at $5.00/gal") )
        {
            observerState = "This is the beginning of the end of the world!" ;
        }
        else if ( subject.getState().equalsIgnoreCase( "The New iPad is out today" ) )
        {
            observerState = "Not another iPad!"  ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Air quality deemed unhealthy as smoke from wildfires reach the bay area." ) )
        {
            observerState = "It's the end of the world!" ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Today is national shark day." ) )
        {
            observerState = "Why would you celebrate sharks?" ;
        }
        else
        {
            observerState = ":(" ;
        }
	}

}
