/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SettingsTest
{
    IApp app ;

    public SettingsTest()
    {
    }

    @Before
    public void setUp()
    {
        app = (IApp) Device.getNewInstance() ;
    }

    @Test
    public void SettingsTest1() {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen().trim());
        app.touch(1,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        app.prev() ;
        assertEquals("Settings", app.screen().trim());
        app.touch(2,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        app.prev() ;
        assertEquals("Settings", app.screen().trim());
        app.touch(3,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        app.prev() ;
        assertEquals("Settings", app.screen().trim());   
    }

    
    @After
    public void tearDown()
    {
    }
}
