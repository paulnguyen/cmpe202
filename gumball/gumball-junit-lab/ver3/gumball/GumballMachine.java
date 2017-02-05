package gumball;

public class GumballMachine implements IGumball
{

    private int num_gumballs;
    private boolean has_quarter;
    private boolean has_gumball;

    public GumballMachine( int size )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_quarter = false;
        this.has_gumball = true ;
    }

    public void insertQuarter() throws GumballException
    {
        this.has_quarter = true ;
    }
    
    public void turnCrank() throws GumballException
    {
        if ( this.has_quarter )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.has_quarter = false ;
                this.has_gumball = true ;
                System.out.println( "Thanks for your quarter.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter." ) ;
            }
        }
        else 
        {
            System.out.println( "Please insert a quarter" ) ;
        }        
    }
    
     public boolean hasGumball() 
     {
         return this.has_gumball ;
     }
     
     public String takeGumball() {
         this.has_gumball = false ;
         return "Gumball" ;
     }
}
