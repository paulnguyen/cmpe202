public class Optimist {

    private String stateOfEconomy = "" ;
    private String myState ;

    public void setEconomy( String e )
    {
        stateOfEconomy  = e ;
    }

    public void display() {
        if ( stateOfEconomy.equalsIgnoreCase("The Price of gas is at $5.00/gal")      )
        {
            myState = "Great! It's time to go green." ;
        }
        else if ( stateOfEconomy.equalsIgnoreCase( "The New iPad is out today" ) )
        {
            myState = "Apple, take my money!" ;
        }
        else
        {
            myState = ":)" ;
        }
        System.out.println( this.getClass().getName() + " = " + myState );
    }

}
 

