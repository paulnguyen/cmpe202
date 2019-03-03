
public class GumballMachine
{

    private int num_gumballs;
    private boolean has_quarter;
    private boolean has_one_cent;
    private boolean has_dime;
    private int countQuarter = 0;
    private int totalValue = 0;

    /**
     * initilized gumble machine
     */
    public GumballMachine( int size )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_quarter = false;
    }

    /**
     * check for inputting quarter
     */
    public void insertQuarter(int coin)
    {
        if ( coin == 25 )
            this.has_quarter = true ;
        else 
            this.has_quarter = false ;
    }
    
     /**
     * check for inputting nickels
     */
    public void insertOneCent (int coin)
    {
        if (coin == 1) 
        this.has_one_cent = true;
        else
        this.has_one_cent = false;
    }
    
     /**
     * check for inputting dime
     */
    public void insertDime (int coin)
    {
        if (coin == 10)
        this.has_dime = true;
        else
        this.has_dime = false;
    }
    
     /**
     * count for two dimes
     */
    public int checkDoubleQuarter () 
    {
    
        for (int i = 0; i<=1; i++)
        {
            if (this.has_quarter)
            {
                countQuarter = countQuarter + 1;
                this.has_quarter = false;
            }
        }
        return countQuarter;
    }
    
   /**
     * count for all coints include nickels, dime and quarter
     */
    public int checkAny50cents()
    {
            
        if (this.has_one_cent)
        {
            totalValue = totalValue + 1;
            this.has_one_cent = false;
        }
        
        if (this.has_dime)
        {
            totalValue = totalValue + 10;
            this.has_dime = false;
        }
        
        if (this.has_quarter)
        {
            totalValue = totalValue + 25;
            this.has_quarter = false;
        }
        
        return totalValue;      
    }
    
     /**
     * return gumball for machine that accepts only quarter
     */
    public void turnCrankForQuarter()
    {
        if ( this.has_quarter )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.has_quarter = false ;
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
    
    /**
     * return gumball for machine that accepts 2 quarters
     */
    public void turnCrankFor2Quarters()
    {
        if ( countQuarter == 2 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                //this.has_quarter = false ;
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
    
    /**
     * return gumball for machine that accepts all coints
     */
    public void turnCrankForAllCoints()
    {
        if ( totalValue == 50 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                //this.has_quarter = false ;
                System.out.println( "Thanks for your coins.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }
        else 
        {
            System.out.println( "Please insert coins" ) ;
        }        
    }
}
