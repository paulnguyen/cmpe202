
public class Realist extends ObserverImpl {

    public Realist( SubjectImpl sub )
    {
        super( sub ) ;
    }

    public void update() {
        if ( subject.getState().equalsIgnoreCase("The Price of gas is at $5.00/gal") )
        {
            observerState = "This is why I went hybrid." ;
        }
        else if ( subject.getState().equalsIgnoreCase( "The New iPad is out today" ) )
        {
            observerState = "Cool."  ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Air quality deemed unhealthy as smoke from wildfires reach the bay area." ) )
        {
            observerState = "Well, most of my work is done remotely anyways." ;
        }
        else if ( subject.getState().equalsIgnoreCase( "Today is national shark day." ) )
        {
            observerState = "Sharks aren't really that dangerous." ;
        }
        else
        {
            observerState = ":/" ;
        }
	}

}
