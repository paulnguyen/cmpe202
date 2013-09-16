/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class MenuCommand implements Command
{
    private AppScreen screen ;

    public MenuCommand( AppScreen scr )
    {
        this.screen = scr ;
    }

    public void execute() {
        
        AppController app = AppController.getInstance() ;
        app.setScreen( screen ) ;
        
    }
}
