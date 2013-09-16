/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KeyPadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KeyPadTest
{
    KeyPad theKeyPad ;

    /**
     * Default constructor for test class KeyPadTest
     */
    public KeyPadTest()
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
        theKeyPad = new KeyPad() ;
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
    public void TestKey1()
    {
        assertEquals("1", theKeyPad.keyPress(1, 1));
    }


    @Test
    public void TestKey2()
    {
        assertEquals("2", theKeyPad.keyPress(2, 1));
    }

    @Test
    public void TestKey3()
    {
        assertEquals("3", theKeyPad.keyPress(3, 1));
    }

    @Test
    public void TestKey4()
    {
        assertEquals("4", theKeyPad.keyPress(1, 2));
    }

    @Test
    public void TestKey5()
    {
        assertEquals("5", theKeyPad.keyPress(2, 2));
    }

    @Test
    public void TestKey6()
    {
        assertEquals("6", theKeyPad.keyPress(3, 2));
    }

    @Test
    public void TestKey7()
    {
        assertEquals("7", theKeyPad.keyPress(1, 3));
    }

    @Test
    public void TestKey8()
    {
        assertEquals("8", theKeyPad.keyPress(2, 3));
    }

    @Test
    public void TestKey9()
    {
        assertEquals("9", theKeyPad.keyPress(3, 3));
    }

    @Test
    public void TestKeyX()
    {
        assertEquals("X", theKeyPad.keyPress(3, 4));
    }

    @Test
    public void TestKey0()
    {
        assertEquals("0", theKeyPad.keyPress(2, 4));
    }

    @Test
    public void TestKeyBlank()
    {
        assertEquals(" ", theKeyPad.keyPress(1, 4));
    }



}

