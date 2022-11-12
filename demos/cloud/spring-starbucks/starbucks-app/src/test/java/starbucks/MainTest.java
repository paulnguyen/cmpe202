/* (c) Copyright 2019 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest
{
     IApp app ;
    
    public MainTest()
    {
    }

    @Before
    public void setUp()
    {
         app = (IApp) Device.getNewInstance("123456") ;
    }

    @After
    public void tearDown()
    {
    }
    

    // Main Scenario for UML Diagram Generation
    // Disable Test Assertions
    @Test
    public void AddCardScenario()
    {
        String[] lines ;
        //assertEquals("", app.screen().trim());
        

        /*** Pin Entry ***/
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        app.touch(2,6) ;  // 5
        app.touch(3,6) ;  // 6
        //assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n"); 
        //assertEquals("$0.00", lines[7].trim());
        app.execute("E") ; // Settings Page
        //assertEquals("Settings", app.screen().trim());
        app.touch(1,1) ; // Add New Card
        //assertEquals("Add Card", app.screen().trim());
        

        /*** Enter Card ID Digits ***/
        app.touch(1,5); 
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        app.touch(3,7);
        app.touch(2,3); // focus on card code


        /*** Enter Card Code Digits ***/
        app.touch(3,7);
        app.touch(3,7);
        app.touch(3,7);
        // check digit entry
        //lines = app.screenContents().split("\n"); 
        //assertEquals("[123456789]", lines[4].trim());
        //assertEquals("[999]", lines[5].trim());
        
        
        /*** See Card Balance ***/
        app.next() ;    
        //assertEquals("My Cards", app.screen().trim());
        //lines = app.screenContents().split("\n");  
        //assertEquals("$20.00", lines[7].trim());    
        

        /*** Make a Payment ***/
        app.touch(3,3); 
        //lines = app.screenContents().split("\n");  
        //assertEquals("[123456789]", lines[6].trim());
        //assertEquals("Scan Now", lines[9].trim());  
        app.touch(2,2);  // Pay $1.50
        app.touch(3,3); // switch to balance
        //lines = app.screenContents().split("\n");  
        //assertEquals("$18.50", lines[7].trim());   
    }   
    
    
    
}
