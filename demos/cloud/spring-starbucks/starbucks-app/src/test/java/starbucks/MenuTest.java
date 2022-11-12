/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuTest
{
     IApp app ;
    
    public MenuTest()
    {
    }

    @Before
    public void setUp()
    {
         app = (IApp) Device.getNewInstance() ;
    }

    @After
    public void tearDown()
    {
    }
    
     @Test
    public void MenuTestTest1()
    {
        String[] lines ;
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n"); 
        assertEquals("$0.00", lines[7].trim());
        app.display() ;
        app.execute("B") ;
        assertEquals("Payments", app.screen().trim());
        lines = app.screenContents().split("\n"); 
        assertEquals("Find Store", lines[7].trim());  
        assertEquals("Enable Payments", lines[8].trim());  
        app.display() ;
    }   
    
    @Test
    public void MenuTestTest2()
    {
        String[] lines ;
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n"); 
        assertEquals("$0.00", lines[7].trim());
        app.display() ;
        app.execute("C") ;
        assertEquals("Rewards", app.screen().trim());
        lines = app.screenContents().split("\n"); 
        assertEquals("Make Every", lines[7].trim());  
        assertEquals("Visit Count", lines[8].trim());  
        app.display() ;
    }  
    
   
    
}
