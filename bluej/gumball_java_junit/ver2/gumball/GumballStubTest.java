package gumball;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballStubTest
{
    private gumball.IGumball m;

    public GumballStubTest()
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
        m = new gumball.GumballStub();
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
        assertEquals(true, m.hasGumball());
    }

    @Test
    public void noQuarter()
    {
        m.turnCrank();
        assertEquals(false, m.hasGumball());
    }

    @Test
    public void test2()
    {
        assertEquals(false, m.hasGumball());
    }
}

