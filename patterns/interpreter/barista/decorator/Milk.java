
package decorator ;


public class Milk implements IRobotCommand
{

    private IRobotCommand component ;
    private String option = null ;

    public Milk(IRobotCommand c)
    {
        this.component = c ;
    }

    public String getCommand( ) 
    {
        return component.getCommand() + (option==null ? "" : "Milk["+option+"] ") ;
    }
    
    public void setOption(String o) 
    {
          this.option = o ;
    }
    
}
