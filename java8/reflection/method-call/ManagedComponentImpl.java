

public class ManagedComponentImpl implements ManagedComponent {

	private String myVersion ;

	public ManagedComponentImpl( String cvstag )
	{
          this.myVersion = cvstag ;
	}

	public String getClassVersion()
	{
          return  this.myVersion  ;
	}

}

