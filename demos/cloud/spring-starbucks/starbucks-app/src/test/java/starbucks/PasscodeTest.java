/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasscodeTest
{

    IApp app ;

    public PasscodeTest()
    {
    }

    @Before
    public void setUp()
    {
        app = (IApp) Device.getNewInstance() ;
    }

   @Test
    public void PasscodeTest1()
    {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("My Cards", app.screen().trim());
    }    

    @After
    public void tearDown()
    {
    }
}
