
public class GumballMachine1
{

    private int cnt = 0;
    private boolean quarterInSlot = false ;

    public GumballMachine1(int count)
    {
        this.cnt = count ;
    }

    public void insertQuarter()
    {
        if ( !quarterInSlot ) {
            quarterInSlot = true ;
        }
        else {
            System.out.println( "There's already a quarter in the slot" ) ;
        }            
    }

    public void turnTheCrank()
    {
        if ( quarterInSlot ) {
            quarterInSlot = false ;
            if ( cnt > 0 ) {
                System.out.println( "Here is your Gumball!  Enjoy!" ) ;
                cnt-- ;
            }
            else {
                System.out.println( "Sorry!  We're out of Gumballs!" ) ;
            }
        }
        else {
            System.out.println( "Crank will not turn without a Quarter!" ) ;
        }              

    }

}
