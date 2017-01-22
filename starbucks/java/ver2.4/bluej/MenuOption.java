
public class MenuOption implements IMenuInvoker
{
    private IMenuCommand cmd ;

    public void setCommand( IMenuCommand c ) {
        cmd = c ;
    }
    public void invoke() 
    {
        cmd.execute() ;
    }
    
}
