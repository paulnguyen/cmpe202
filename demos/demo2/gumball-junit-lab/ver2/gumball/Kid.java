package gumball;


/**
 * Write a description of class Kid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kid
{
    private IGumball machine;

    /**
     * Constructor for objects of class Kid
     */
    public Kid( IGumball m )
    {
        machine = m ;
    }


    public void Mommy()
    {
        machine.insertQuarter() ;
        machine.turnCrank() ;
    }
}
