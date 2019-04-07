
/**
 * Write a description of class KeyPad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyPad implements ITouchEventHandler, IDisplayComponent, IKeyPadSubject
{
    ITouchEventHandler nextHandler ;
    IKeyPadObserver observer ;
    int countPinDigits = 0 ;
    
    public void touch(int x, int y) { 
        if ( y > 4 )
        {
            System.out.println( "KeyPad Touched at (" + x + ", " + y + ")" ) ; 
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
    
    public void attach(IKeyPadObserver o) 
    {
        observer = o ;
    }
    
    public void notifyObservers() 
    {
        observer.update( countPinDigits ) ;
    }
    
    
}
