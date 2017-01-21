import java.util.ArrayList;

/**
 * Write a description of class KeyPad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyPad implements ITouchEventHandler, IDisplayComponent, IKeyPadSubject
{
    ITouchEventHandler nextHandler ;
    private ArrayList<IKeyPadObserver> observers ;
    int countPinDigits = 0 ;
    String lastKey = "" ;

    public KeyPad()
    {
        observers = new ArrayList<IKeyPadObserver>() ;
    }

    public void touch(int x, int y) { 
        if ( y > 4 )
        {
            System.out.println( "KeyPad Touched at (" + x + ", " + y + ")" ) ; 
            this.lastKey = getKey( x, y ) ;
            if ( x==3 && y==8   )
            {
                countPinDigits-- ;
            }
            else if ( y < 8 || (x==2 && y==8))
            {
                countPinDigits++ ;
            }
            notifyObservers() ;            
        }
        else
        {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
    }

    private String getKey( int x, int y )
    {
        int kx = 0, ky = 0 ;
        kx = x;
        ky = y-4 ;
        if ( kx==3 && ky ==4 )
            return "X" ;
        else if ( kx==2 && ky == 4 )
            return "0" ;
        else if ( kx==1 && ky ==4 )
            return " " ;
        else
            return Integer.toString(kx+3*(ky-1)) ;   
    }

    /**
    kx = 1, ky = 1  ==> 1
    kx = 1, ky = 2  ==> 4
    kx = 1, ky = 3  ==> 7

    kx = 2, ky = 1  ==> 2
    kx = 2, ky = 2  ==> 5
    kx = 2, ky = 3  ==> 8

    kx = 3, ky = 1  ==> 3
    kx = 3, ky = 2  ==> 6
    kx = 4, ky = 3  ==> 9

    n = kx + 3 * (ky-1)

     */

    public void setNext( ITouchEventHandler next) { 
        nextHandler = next ;
    }

    public String display() 
    {
        return " [1] [2] [3]\n [4] [5] [6]\n [7] [8] [9]\n [_] [0] [X]"  ;
    }

    public void addSubComponent( IDisplayComponent c ) 
    {
    }

    public void attach( IKeyPadObserver obj ) 
    {
        observers.add( obj ) ;
    }

    public void removeObserver( IKeyPadObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    public void notifyObservers( )
    {
        for (int i=0; i<observers.size(); i++)
        {
            IKeyPadObserver observer = observers.get(i) ;
            observer.keyEventUpdate( countPinDigits, lastKey ) ;
        }
    }    

}
