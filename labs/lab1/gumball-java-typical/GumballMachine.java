import java.util.Arrays;
public class GumballMachine
{
    private int num_gumballs;
    private boolean has_amount;
    private int[] acceptedCoins;
    private int gumballCost;
    private int currentAmount;  
    
    public GumballMachine( int size,int acceptCoins[],int gumballcost)
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_amount = false;
        this.acceptedCoins = Arrays.copyOf(acceptCoins, acceptCoins.length);
        this.gumballCost = gumballcost;
        this.currentAmount=0;
    }
    //Function  to accept coins and validate if 25 or 50 cents amount is inserted
 
    public void insertCoin(int coins[])
    {
         this.currentAmount= 0; // initialize sum
         // add condition to check if only 5 10 and 25 coins are inserted    
         for (int i = 0; i < coins.length; i++)
           {   if(coins[i] == 5 || coins[i] == 10 || coins[i] == 25 ) //
               {  this.currentAmount +=  coins[i]; }
               else 
                { System.out.println("Insert only Nickel,Dime or Quarters") ;}
            }
         if ( this.currentAmount == this.gumballCost )
             { this.has_amount = true ; }
           else 
           { this.has_amount = false ; }
    
}
   
    public void turnCrank()
    {
        if ( this.has_amount )
        {       
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;  
                this.currentAmount = 0;
                System.out.println( "Thanks for your quarter.Gumball Ejected!" ) ;
            }
            else
            {
                  System.out.println( "No More Gumballs!Sorry, can't return your quarter.") ;
            }
            this.has_amount = false ;
            
        }
        else 
        {   //calculate how much more is required and print accordingly
            int needMoney = 0;
            needMoney=(this.gumballCost - this.currentAmount);    
            System.out.println( "Please insert more " + needMoney + " cents to get one gumball" ) ;
        }        
    }
}






