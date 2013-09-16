/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AppControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppControllerTest
{
    private AppController app;

    /**
     * Default constructor for test class AppControllerTest
     */
    public AppControllerTest()
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
        app = AppController.getInstance();
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
    public void TestMenus()
    {
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        app.menu1();
        assertEquals("MyCardsMainScreen", app.getCurrentScreenName());
        app.menu2();
        assertEquals("PaymentScreen", app.getCurrentScreenName());
        app.menu3();
        assertEquals("RewardScreen", app.getCurrentScreenName());
        app.menu4();
        assertEquals("FindStarbuckScreen", app.getCurrentScreenName());
        app.menu5();
        assertEquals("SettingScreen", app.getCurrentScreenName());
    }
}


