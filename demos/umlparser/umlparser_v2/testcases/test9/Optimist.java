
public class Optimist extends ObserverImpl {

    public Optimist( SubjectImpl sub )
    {
        super( sub ) ;
    }

	public void update() {
	    if ( subject.getState().equalsIgnoreCase("The Price of gas is at $5.00/gal")      )
        {
             observerState = "Great! It's time to go green." ;
        }
        else if ( subject.getState().equalsIgnoreCase( "The New iPad is out today" ) )
        {
            observerState = "Apple, take my money!" ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Air quality deemed unhealthy as smoke from wildfires reach the bay area." ) )
        {
            observerState = "No problem! I don't want to go outside anyways." ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Today is national shark day." ) )
        {
            observerState = "I love sharks!" ;
        }
        else
        {
            observerState = ":)" ;
        }
	}

}
