
public class Pessimist {

    private String stateOfEconomy = "" ;
    private String myState ;

    public void setEconomy( String e )
    {
        stateOfEconomy  = e ;
    }

    public void display() {
        if ( stateOfEconomy.equalsIgnoreCase("The Price of gas is at $5.00/gal")      )
        {
            myState = "This is the beginning of the end of the world!" ;
        }
        else if ( stateOfEconomy.equalsIgnoreCase( "The New iPad is out today" ) )
        {
            myState = "Not another iPad!" ;
        }
        else
        {
            myState = ":(" ;
        }
        System.out.println( this.getClass().getName() + " = " +  myState );
    }

}
