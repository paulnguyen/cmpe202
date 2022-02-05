package gumball;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{

    private gumball.IGumball m;

    /**
     * Default constructor for test class Test
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //m = new gumball.GumballMachine(10);
        m = new gumball.GumballStub() ;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    
    @Test
    public void testHappy()
    {
        try {            
            m.insertQuarter();
            m.turnCrank();
            assertEquals(true, m.hasGumball());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }

    @Test
    public void testNoQuarter()
    {
        try {
            m.turnCrank();
            assertEquals(false, m.hasGumball());
        }
        catch ( NoQuarterException e )
        {
            assertTrue(true) ;   
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }
    
    
    @Test
    public void testHasQuarter()
    {
        try {
            m.insertQuarter();
            m.insertQuarter();
            fail( "Should Throw an Exception" ) ;
        }
        catch ( HasQuarterException e )
        {
            assertTrue(true) ;   
        }
        catch ( GumballException e )
        {
             fail( "Invalid Exception Thrown!" ) ;
        }
    }
        

}


