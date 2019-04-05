public class Drink implements IRobotCommand
{
    
    private IRobotCommand component ;
    private String option = null ;

    public Drink(IRobotCommand c)
    {
        this.component = c ;
    }

    public String getCommand( ) 
    {
        return component.getCommand() + (option==null ? "" : "Drink["+option+"] ") ;
    }
    
    public void setOption(String o) 
    {
         this.option = o ;
    }    
}
