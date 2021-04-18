
/**
 * Write a description of class Passcode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Passcode implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver
{
    ITouchEventHandler nextHandler ;
    private int count = 0;
    
    public void touch(int x, int y) 
    {
        if ( y==2 )
        {
            System.out.println( "Passcode Touched at (" + x + ", " + y + ")" ) ; 
        }
        else
        {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
    }
    
    public void setNext( ITouchEventHandler next) 
    { 
        nextHandler = next ;
    }
    
    
    public String display() 
    {
        String value = "" ;
        switch ( count )
        {
            case 0: value = " [_][_][_][_]" ; break ;
            case 1: value = " [*][_][_][_]" ; break ;
            case 2: value = " [*][*][_][_]" ; break ;
            case 3: value = " [*][*][*][_]" ; break ;
            case 4: value = " [*][*][*][*]" ; break ;
        }
         return value  ;
    }
    
    public void addSubComponent( IDisplayComponent c ) 
    {
        
    }   
    
    public void keyEventUpdate( int c, String key ) 
    {
        count = c ;
    }
}
