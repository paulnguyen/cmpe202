package gumball;


/**
 * Write a description of interface IGumball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IGumball
{

    public void insertQuarter() throws GumballException ;
    public void turnCrank() throws GumballException ;
    public boolean hasGumball() ;
    public String takeGumball() ;
}
