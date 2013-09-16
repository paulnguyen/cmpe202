/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class Passcode implements PinEntryObserver {

    private int num_pin_digits ;

    public Passcode()
    {
        this.num_pin_digits = 0 ;
    }

    public void touch(int x, int y) {    
    }
    
    public String display()
    {
        String str ;
        switch( num_pin_digits )
        {
            case 0: str = "_ _ _ _" ; break ;
            case 1: str = "* _ _ _" ; break ;
            case 2: str = "* * _ _" ; break ;
            case 3: str = "* * * _" ; break ;
            case 4: str = "* * * *" ; break ;
            default: str = "_ _ _ _" ;
        }
        System.out.println( str ) ;
        return str ;    
    }
     
    public void update(int count)
    {
        this.num_pin_digits = count ;
        display() ;
    }
}
 
