

public class ObserverImpl implements Observer {

	protected String observerState;
	protected SubjectImpl subject;

    public ObserverImpl( SubjectImpl theSubject )
    {
        this.subject = theSubject ;
    }

	public void update() {
	    // do nothing
	}

    public void showState()
    {
        System.out.println( "Observer: " + this.getClass().getName() + " = " + observerState );
    }

}
