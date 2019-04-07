
package decorator ;


public class Shots implements IRobotCommand
{

    private IRobotCommand component ;
    private String option = null ;

    public Shots(IRobotCommand c)
    {
        this.component = c ;
    }

    public String getCommand( ) 
    {
         return component.getCommand() + (option==null ? "" : "Shots["+option+"] ") ;
    }
    
    public void setOption(String o) 
    {
         this.option = o ;
    }
    
}
