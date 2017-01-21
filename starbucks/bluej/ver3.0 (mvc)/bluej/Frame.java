
public class Frame
{
    private String title ;
    private Model model ;
    private View view ;
    private Controller controller ;
    private IActionCommand button ;
    
    public Frame( String title )
    {
        this.title = title ;
        this.model = new Model() ;
        this.view = new View() ;
        this.controller = new Controller() ;
        this.model.attachObserver( view ) ;
        this.model.attachObserver( controller ) ; 
        this.view.initialize( model ) ;
        this.controller.initialize( model, view ) ;
    }
    
    public void setButton( IActionCommand cmd )
    {
        this.button = cmd ;
        this.button.setReceiver( controller ) ;
    }
    
    public void enterInput( String input )
    {
        controller.setInput( input ) ;
    }
    
    public void buttonClick()
    {
        button.execute() ;
    }
    
    public void display()
    {
        System.out.println( "   "  + title ) ;
        System.out.println( " +-------------------------+ " ) ;
        System.out.print( "  " ) ;
        view.display() ;
        System.out.println( " +-------------------------+ " ) ;
    }
}
