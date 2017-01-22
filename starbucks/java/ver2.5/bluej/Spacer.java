
public class Spacer implements IDisplayComponent, ITouchEventHandler
{
    ITouchEventHandler nextHandler ;

    public String display() { return "\n" ; }
    public void addSubComponent( IDisplayComponent c ) {}
    
   public void touch(int x, int y) 
    {
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
    }
    
    public void setNext( ITouchEventHandler next) 
    { 
        nextHandler = next ;
    }
    
}
