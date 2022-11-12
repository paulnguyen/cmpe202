/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StrategyPatternTest
{
    IApp app ;

    public StrategyPatternTest()
    {
    }

    @Before
    public void setUp()
    {
        app = (IApp) Device.getNewInstance() ;
    }


    @Test
    public void StrategyPatternTest1()
    {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("My Cards", app.screen().trim());
        app.landscape();
        assertEquals("My Cards", app.screen().trim());
        app.execute( "E" ) ;  
        assertEquals("My Cards", app.screen().trim());         
    }

    @Test
    public void StrategyPatternTest2()
    {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("My Cards", app.screen().trim());
        app.landscape();
        assertEquals("My Cards", app.screen().trim());
        app.execute( "B" ) ;  
        assertEquals("My Cards", app.screen().trim());         
    }    

    @Test
    public void StrategyPatternTest3()
    {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("My Cards", app.screen().trim());
        app.landscape();
        assertEquals("My Cards", app.screen().trim());
        app.execute( "C" ) ;  
        assertEquals("My Cards", app.screen().trim());         
    }    

    @Test
    public void StrategyPatternTest4()
    {
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        assertEquals("My Cards", app.screen().trim());
        app.landscape();
        assertEquals("My Cards", app.screen().trim());
        app.execute( "D" ) ;  
        assertEquals("My Cards", app.screen().trim());         
    }    

    @Test
    public void StrategyPatternTest5()
    {
        String[] lines ;        
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        assertEquals("My Cards", app.screen().trim());
        app.portrait();
        assertEquals("My Cards", app.screen().trim());
        app.execute( "B" ) ;  
        assertEquals("Payments", app.screen().trim());          
        app.execute( "A" ) ;
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("$0.00", lines[7].trim());        
        app.landscape(); 
        app.display() ;
        app.touch(2,4) ;  
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("$0.00", lines[5].trim());        
        app.touch(1, 7) ;
        assertEquals("My Cards", app.screen().trim());
        app.execute( "E" ) ;  
        assertEquals("My Cards", app.screen().trim());        
    } 

    @After
    public void tearDown()
    {
    }
}
