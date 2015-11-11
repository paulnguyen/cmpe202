
public class Frame
{
    private IScreen current ;
    private IMenuInvoker menuA = new MenuOption() ;
    private IMenuInvoker menuB = new MenuOption() ;
    private IMenuInvoker menuC = new MenuOption() ;
    private IMenuInvoker menuD = new MenuOption() ;
        
    public Frame(IScreen initial)
    {
        current = initial ;
    }
    
    public void setCurrentScreen( IScreen s )
    {
        current = s ;
    }
    
    public void setMenuItem( String slot, IMenuCommand c )
    {
        if ( "A".equals(slot) ) { menuA.setCommand(c) ;  }
        if ( "B".equals(slot) ) { menuB.setCommand(c) ; }
        if ( "C".equals(slot) ) { menuC.setCommand(c) ; }
        if ( "D".equals(slot) ) { menuD.setCommand(c) ; }                
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
    
    public void selectA() { menuA.invoke() ;  }
    public void selectB() { menuB.invoke() ;  }
    public void selectC() { menuC.invoke() ;  }
    public void selectD() { menuD.invoke() ;  }
    
}
