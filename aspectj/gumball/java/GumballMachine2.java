
public class GumballMachine2
{

    private int cnt = 0;
    private int coinValue = 0 ;

    public GumballMachine2(int count)
    {
        this.cnt = count ;
    }

    public void insertQuarter()
    {
        if ( coinValue < 50 ) {
            coinValue += 25 ;
        }
        else {
            System.out.println( "There are already quarters in the slot" ) ;
        }            
    }

    public void turnTheCrank()
    {
        if ( coinValue == 50 ) {
            coinValue = 0 ;
            if ( cnt > 0 ) {
                System.out.println( "Here is your Gumball!  Enjoy!" ) ;
                cnt-- ;
            }
            else {
                System.out.println( "Sorry!  We're out of Gumballs!" ) ;
            }
        }
        else {
            System.out.println( "Crank will not turn without Quarters!" ) ;
        }              

    }

}
