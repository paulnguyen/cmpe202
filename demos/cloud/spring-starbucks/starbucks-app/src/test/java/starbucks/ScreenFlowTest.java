/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScreenFlowTest
{
    IApp app ;

    public ScreenFlowTest()
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
    public void ScreenFlowTest1()
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
        app.touch(3,3) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("[000000000]", lines[6].trim());
        assertEquals("Scan Now", lines[9].trim());
        app.display() ;
    }

    @Test
    public void ScreenFlowTest2()
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
        app.touch(2,4) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("Reload",          lines[6].trim()); 
        assertEquals("Refresh",         lines[7].trim()); 
        assertEquals("More Options",    lines[8].trim()); 
        assertEquals("Cancel",          lines[9].trim()); 
    }    

    @Test
    public void ScreenFlowTest3()
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
        app.touch(2,4) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("Reload",          lines[6].trim()); 
        assertEquals("Refresh",         lines[7].trim()); 
        assertEquals("More Options",    lines[8].trim()); 
        assertEquals("Cancel",          lines[9].trim()); 
        app.touch(1, 7) ;
        assertEquals("My Cards", app.screen().trim());
    }        

    @Test
    public void ScreenFlowTest4()
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
        app.touch(2,4) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("Reload",          lines[6].trim()); 
        assertEquals("Refresh",         lines[7].trim()); 
        assertEquals("More Options",    lines[8].trim()); 
        assertEquals("Cancel",          lines[9].trim()); 
        app.touch(2, 7) ;
        assertEquals("My Cards", app.screen().trim());
    }        

    @Test
    public void ScreenFlowTest5()
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
        app.touch(2,4) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("Reload",          lines[6].trim()); 
        assertEquals("Refresh",         lines[7].trim()); 
        assertEquals("More Options",    lines[8].trim()); 
        assertEquals("Cancel",          lines[9].trim()); 
        app.touch(3, 7) ;
        assertEquals("My Cards", app.screen().trim());
    }        

    @Test
    public void ScreenFlowTest6()
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
        app.touch(3,3) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("[000000000]", lines[6].trim());
        assertEquals("Scan Now", lines[9].trim());
        app.display() ;
        app.touch(3,3) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("$0.00", lines[7].trim());        
    }    

    @Test
    public void ScreenFlowTest7()
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
        for ( int x = 1; x<=3; x++ )
            for ( int y = 1; y<=2; y++ )
            {
                app.touch(x,y) ;
                assertEquals("My Cards", app.screen().trim());
            }
        app.touch(1,3) ;
        assertEquals("My Cards", app.screen().trim());
        app.touch(2,3) ;
        assertEquals("My Cards", app.screen().trim());
        app.touch(1,4) ;
        assertEquals("My Cards", app.screen().trim());
        app.touch(3,4) ;
        assertEquals("My Cards", app.screen().trim());
        for ( int x = 1; x<=3; x++ )
            for ( int y = 5; y<=8; y++ )
            {
                app.touch(x,y) ;
                assertEquals("My Cards", app.screen().trim());
            }
    }
    
    
}
