/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class KeyPad {
 
    public String keyPress( int x, int y )
    {
        if ( x==3 && y ==4 )
            return "X" ;
        else if ( x==2 && y == 4 )
            return "0" ;
        else if ( x==1 && y ==4 )
            return " " ;
        else
            return Integer.toString(x+3*(y-1)) ;   
    }
    
    public KeyPad()
    {}
    
}

/**

 x = 1, y = 1  ==> 1
 x = 1, y = 2  ==> 4
 x = 1, y = 3  ==> 7
 
 x = 2, y = 1  ==> 2
 x = 2, y = 2  ==> 5
 x = 2, y = 3  ==> 8
 
 x = 3, y = 1  ==> 3
 x = 3, y = 2  ==> 6
 x = 4, y = 3  ==> 9
 
 n = x + 3 * (y-1)
 
 */
 
