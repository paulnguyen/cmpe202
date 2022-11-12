/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KeyPadPressTest
{
    private KeyPad kp ;
    private PinEntryMachine pm ;
    
    public KeyPadPressTest()
    {
    }

    @Before
    public void setUp()
    {
        kp = new KeyPad() ;
        pm = new PinEntryMachine() ;
        ((IKeyPadSubject)kp).attach( pm ) ;   
    }


    @Test
    public void KeyPadPressTest1()
    {
        kp.touch(1,5) ;
        assertEquals( "1", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest2()
    {
        kp.touch(2,5) ;
        assertEquals( "2", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest3()
    {
        kp.touch(3,5) ;
        assertEquals( "3", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest4()
    {
        kp.touch(1,6) ;
        assertEquals( "4", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest5()
    {
        kp.touch(2,6) ;
        assertEquals( "5", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest6()
    {
        kp.touch(3,6) ;
        assertEquals( "6", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest7()
    {
        kp.touch(1,7) ;
        assertEquals( "7", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest8()
    {
        kp.touch(2,7) ;
        assertEquals( "8", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest9()
    {
        kp.touch(3,7) ;
        assertEquals( "9", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest10()
    {
        kp.touch(2,8) ;
        assertEquals( "0", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest11()
    {
        kp.touch(3,8) ;
        assertEquals( "X", kp.lastKey() );
    }

   @Test
    public void KeyPadPressTest12()
    {
        kp.touch(1,8) ;
        assertEquals( " ", kp.lastKey() );
    }

    
     @Test
    public void ObserverPatternTest1()
    {
        kp.touch(1,5) ; 
        assertEquals("1", pm.d1());
    }

    @Test
    public void ObserverPatternTest2()
    {
        kp.touch(1,5) ;
        kp.touch(2,5) ;       
        assertEquals("1", pm.d1());
        assertEquals("2", pm.d2());
    }

    @Test
    public void ObserverPatternTest3()
    {
        kp.touch(1,5) ;
        kp.touch(2,5) ;       
        kp.touch(3,5) ;       
        assertEquals("1", pm.d1());
        assertEquals("2", pm.d2());
        assertEquals("3", pm.d3());
     }

    @Test
    public void ObserverPatternTest4()
    {
        kp.touch(1,5) ;
        kp.touch(2,5) ;       
        kp.touch(3,5) ;    
        kp.touch(1,6) ;     
        assertEquals("1", pm.d1());
        assertEquals("2", pm.d2());
        assertEquals("3", pm.d3());
        assertEquals("4", pm.d4());
    }

   @Test
    public void ObserverPatternTest5()
    {
        kp.touch(1,5) ;
        kp.touch(2,5) ;       
        kp.touch(3,5) ;    
        kp.touch(1,6) ;     
        assertEquals("1", pm.d1());
        assertEquals("2", pm.d2());
        assertEquals("3", pm.d3());
        assertEquals("4", pm.d4());
        kp.touch(3,8) ;
        assertEquals("1", pm.d1());
        assertEquals("2", pm.d2());
        assertEquals("3", pm.d3());
        assertEquals("" , pm.d4());
    }
    

    @After
    public void tearDown()
    {
    }
}
