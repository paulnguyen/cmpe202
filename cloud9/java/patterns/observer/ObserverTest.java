package observer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ObserverTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ObserverTest
{
    /**
     * Default constructor for test class ObserverTest
     */
    public ObserverTest()
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
    public void test1()
    {
        observer.TheEconomy s = new observer.TheEconomy();
        observer.Pessimist p = new observer.Pessimist(s);
        observer.Optimist o = new observer.Optimist(s);
        s.attach(p);
        s.attach(o);
        s.setState("The New iPad is out today");
        s.setState("Hey, Its Friday!");
        p.showState();
        o.showState();
    }
}

