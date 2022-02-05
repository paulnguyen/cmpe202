package gumball;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KidTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KidTest
{
    private gumball.IGumball m;

    /**
     * Default constructor for test class KidTest
     */
    public KidTest()
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
        m.insertQuarter();
        m.turnCrank();
    }

    @Test
    public void testHappy2()
    {
        m.insertQuarter();
        m.turnCrank();
        assertEquals(true, m.hasGumball());
    }

    @Test
    public void noQuarter()
    {
        m.turnCrank();
        assertEquals(false, m.hasGumball());
    }
}



