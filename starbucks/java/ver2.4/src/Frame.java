
public class Frame
{
    private IScreen current ;
    private IMenuInvoker menuA = new MenuOption() ;
    private IMenuInvoker menuB = new MenuOption() ;
    private IMenuInvoker menuC = new MenuOption() ;
    private IMenuInvoker menuD = new MenuOption() ;
    private IOrientationStrategy portraitStrategy ;
    private IOrientationStrategy landscapeStrategy ;
    private IOrientationStrategy currentStrategy ;
        
   public void landscape() { currentStrategy = landscapeStrategy ; }
   public void portrait()  { currentStrategy = portraitStrategy ; }  
    
    public Frame(IScreen initial)
    {
        current = initial ;
               
        portraitStrategy = new IOrientationStrategy() 
        {
            public void display(IScreen s)
            {
                System.out.println( "  " + s.getClass().getName() + "  " ) ;
                System.out.println( "================\n" ) ;
                System.out.println( s.display() ) ;
                System.out.println( "================\n" ) ;
                System.out.println( " [A][B][C][D]" ) ;
            }         
            public void selectA() { menuA.invoke() ; }
            public void selectB() { menuB.invoke() ; }
            public void selectC() { menuC.invoke() ; }
            public void selectD() { menuD.invoke() ; }
        } ;

        landscapeStrategy = new IOrientationStrategy() 
        {
            public void display(IScreen s)
            {
                System.out.println( "  " + s.getClass().getName() + "  " ) ;
                System.out.println( "================================\n" ) ;
                System.out.println( s.display() ) ;
                System.out.println( "================================\n" ) ;
            }         
            public void selectA() {  }
            public void selectB() {  }
            public void selectC() {  }
            public void selectD() {  }
        } ;     
        
        /* set default layout strategy */
        currentStrategy = portraitStrategy ;
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
            currentStrategy.display( current ) ;
        }
    }
    
    public void cmd( String c ) 
    {
        if ( "A".equals(c) ) { selectA() ; }
        if ( "B".equals(c) ) { selectB() ; }
        if ( "C".equals(c) ) { selectC() ; }
        if ( "D".equals(c) ) { selectD() ; }        
    }
    
    public void selectA() { currentStrategy.selectA() ;  }
    public void selectB() { currentStrategy.selectB() ;  }
    public void selectC() { currentStrategy.selectC() ;  }
    public void selectD() { currentStrategy.selectD() ;  }
    
}
