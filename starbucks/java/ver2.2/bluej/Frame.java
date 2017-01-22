
public class Frame
{
    private IScreen current ;
    private IScreen screenA ;
    private IScreen screenB ;
    private IScreen screenC ;
    private IScreen screenD ;
        
    public Frame(IScreen initial)
    {
        current = initial ;
        screenA = null ;
        screenB = null ;
        screenC = null ;
        screenD = null ;
    }
    
    public void setScreen( String slot, IScreen s )
    {
        if ( "A".equals(slot) ) { screenA = s ; }
        if ( "B".equals(slot) ) { screenB = s ; }
        if ( "C".equals(slot) ) { screenC = s ; }
        if ( "D".equals(slot) ) { screenD = s ; }                
    }
    
    public void touch(int x, int y)
    {
        if ( current != null )
            current.touch(x,y) ;

    }
    
    public void display()
    {
        if ( current != null )
        {
            System.out.println( "  " + current.getClass().getName() + "  " ) ;
            System.out.println( "================\n" ) ;
            System.out.println( current.display() ) ;
            System.out.println( "================\n" ) ;
            System.out.println( " [A][B][C][D]" ) ;
        }
    }
    
    public void cmd( String c ) 
    {
        if ( "A".equals(c) ) { selectA() ; }
        if ( "B".equals(c) ) { selectB() ; }
        if ( "C".equals(c) ) { selectC() ; }
        if ( "D".equals(c) ) { selectD() ; }        
    }
    
    public void selectA() { current=screenA;  }
    public void selectB() { current=screenB;  }
    public void selectC() { current=screenC;  }
    public void selectD() { current=screenD;  }
    
}
