
public class Controller implements IObserver, IActionListener, IKeyListener, IWindowListener, IMouseListener
{

    private Model model ;
    private View view ;
    
    public Controller( )
    {
        model = null ;
        view = null ;
    }

    public void initialize( Model m, View v )
    {   
        this.model = m ;
        this.view = v ;
    }
    
    public void update() 
    {
    }
    
    public void setInput( String msg )
    {
        model.setData( "Hello " + msg ) ;
    }
    

    public void handleWindowEvent() { }
    public void handleMouseEvent() { }
    public void handleKeyEvent() { }
    public void handleActionEvent( Constants event ) 
    { 
      if ( event == Constants.EXIT_EVENT )
        System.out.println( "  Goodbye!" ) ;
    }
    
}
