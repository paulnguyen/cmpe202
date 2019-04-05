public class Decaf implements IRobotCommand
{
    private IRobotCommand component ;
    private String option = null ;

    public Decaf(IRobotCommand c)
    {
        this.component = c ;
    }

    public String getCommand( ) 
    {
        return component.getCommand() + (option==null ? "" : "Decaf["+option+"] ") ;
    }
    
    public void setOption(String o) 
    {
         this.option = o ;
    }
}
