/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PinMachineTest
{
    PinEntryMachine pinEntry ;
    

    public PinMachineTest()
    {
    }

    @Before
    public void setUp()
    {
        pinEntry = new PinEntryMachine();
    }

    @Test
    public void PinMachineTest1()
    {
        pinEntry.number("1");
        pinEntry.backspace();
        System.out.println( pinEntry.getCurrentState() ) ;
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
        pinEntry.backspace();
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest2()
    {
        pinEntry.number("1");
        assertEquals("starbucks.OnePinDigit", pinEntry.getCurrentState());
        pinEntry.number("2");
        pinEntry.backspace();
        assertEquals("starbucks.OnePinDigit", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest3()
    {
        pinEntry.number("1");
        pinEntry.number("2");
        assertEquals("starbucks.TwoPinDigits", pinEntry.getCurrentState());
        pinEntry.number("3");
        pinEntry.backspace();
        assertEquals("starbucks.TwoPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest4()
    {
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        assertEquals("starbucks.ThreePinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest5()
    {
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("4");
        assertEquals("starbucks.FourPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest6()
    {
        pinEntry.number("1");
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("5");
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
    }

    @Test
    public void PinMachineTest7()
    {
        pinEntry.number("1");
        pinEntry.backspace();
        System.out.println( pinEntry.getCurrentState() ) ;
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("5");
        pinEntry.backspace();
        assertEquals("starbucks.TwoPinDigits", pinEntry.getCurrentState());
    }    

    @Test
    public void PinMachineTest8()
    {
        pinEntry.number("1");
        pinEntry.backspace();
        System.out.println( pinEntry.getCurrentState() ) ;
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
        pinEntry.number("2");
        pinEntry.number("3");
        pinEntry.number("5");
        assertEquals("starbucks.ThreePinDigits", pinEntry.getCurrentState());
        pinEntry.number("1");
        assertEquals("starbucks.NoPinDigits", pinEntry.getCurrentState());
    }
            
    @After
    public void tearDown()
    {
    }
}
