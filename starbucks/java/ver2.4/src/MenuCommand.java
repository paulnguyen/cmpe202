
public class MenuCommand implements IMenuCommand
{
    IMenuReceiver target ;
    
    public void execute() 
    {
        target.doAction() ;
    }
    
    public void setReceiver( IMenuReceiver t ) 
    {
        target = t ;
    }
}
