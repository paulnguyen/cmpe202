package gumball;


/**
 * Write a description of class GumballStub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballStub implements IGumball
{
    boolean hasQuarter ;
    boolean hasGumball ;
    
    public GumballStub() { 
        hasQuarter = false ; 
        hasGumball = false ; 
    }
    
    public void insertQuarter() throws GumballException
    { 
        if ( this.hasQuarter )
        {
            throw new HasQuarterException() ;
        }
        else
        {
            this.hasQuarter = true ; 
        }
    }
    
    public void turnCrank() throws GumballException
    { 
        if ( this.hasQuarter )
        {
            this.hasGumball = true ; 
            this.hasQuarter = false ; 
        }
        else
        {
            throw new NoQuarterException() ;
        }
    }
    
    public boolean hasGumball() { 
        return this.hasGumball; 
    }
    
    public String takeGumball() {
        if ( this.hasGumball )
        {
            this.hasGumball = false ;
            return "Gumball" ;
        }
        else
        {
            return "" ;
        }
    }
}
