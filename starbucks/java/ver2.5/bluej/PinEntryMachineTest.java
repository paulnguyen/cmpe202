

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PinEntryMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PinEntryMachineTest
{
    PinEntryMachine pinEntry ;
    
    /**
     * Default constructor for test class PinEntryMachineTest
     */
    public PinEntryMachineTest()
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
        pinEntry = new PinEntryMachine();
    }

    

    @Test
    public void test0()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        pinEntry.backspace();
        assertEquals("NoPinDigits", pinEntry.getCurrentState());
        pinEntry.backspace();
        assertEquals("NoPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void test1()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        assertEquals("OnePinDigit", pinEntry.getCurrentState());
        pinEntry.number("2");
        pinEntry.backspace();
        assertEquals("OnePinDigit", pinEntry.getCurrentState());
    }

    @Test
    public void test2()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        pinEntry.number("2");
        assertEquals("TwoPinDigits", pinEntry.getCurrentState());
        pinEntry.number("3");
        pinEntry.backspace();
        assertEquals("TwoPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void test3()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        assertEquals("ThreePinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void test4()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("4");
        assertEquals("FourPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void test5()
    {
        PinEntryMachine pinEntry = new PinEntryMachine();
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("5");
        assertEquals("NoPinDigits", pinEntry.getCurrentState());
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
}
