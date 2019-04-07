
/**
 * Write a description of class PinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.* ;

public class PinScreen implements IScreen, IDisplayComponent
{
    private ArrayList<IDisplayComponent> components = new ArrayList<IDisplayComponent>() ;
    private ITouchEventHandler chain ;

    public PinScreen()
    {
    }

    public void touch(int x, int y) {
        chain.touch(x, y) ;
    }
    
    public void addSubComponent( IDisplayComponent c )
    {
        components.add( c ) ;
        if (components.size() == 1 )
        {
            chain = (ITouchEventHandler) c ;
        }
        else
        {
            ITouchEventHandler prev = (ITouchEventHandler) components.get(components.size()-2) ;
            prev.setNext( (ITouchEventHandler) c ) ;
        }
    }
    
    public String display() { 
        String value = "" ;
        for (IDisplayComponent c : components )
        {
            value = value + c.display() + "\n" ;
        }
        return value ; 
    }

}


