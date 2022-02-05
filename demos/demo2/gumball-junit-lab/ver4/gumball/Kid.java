package gumball;

public class Kid
{
    private IGumball machine;
    private int numQuarters ;
    private int numGumballs ;

    /**
     * Constructor for objects of class Kid
     */
    public Kid( IGumball m )
    {
        machine = m ;
        numQuarters = 0 ;
        numGumballs = 0 ;
    }

    public void giveQuarters( int q )
    {
        numQuarters += q ;
    }
    
    public void buyGumball() 
    {
        try 
        {
            if ( numQuarters > 0 )
            {
                numQuarters-- ;
                machine.insertQuarter() ;
                machine.turnCrank() ;
                if ( machine.hasGumball() )
                {
                    machine.takeGumball() ;
                    numGumballs++ ;
                }
            }
            else
            {
                System.out.println( "I'm out of quarters!" ) ;
            }
        }
        catch( Exception e ) {}
    }
}
