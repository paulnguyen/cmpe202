/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PaymentsTest
{

    IApp app ;

    public PaymentsTest()
    {

    }

    @Before
    public void setUp()
    {
        app = (IApp) Device.getNewInstance() ;
    }

    @Test
    public void PaymentsTest1()
    {
        String[] lines ;
        assertEquals("", app.screen().trim());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen().trim());
        app.touch(1,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        // Card Id digits
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
        // Card Code digits
        app.touch(3,7);
        app.touch(3,7);
        app.touch(3,7);
        // check digit entry
        lines = app.screenContents().split("\n"); 
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
        // add card - see balance
        app.next() ;    
        assertEquals("My Cards", app.screen().trim());
        lines = app.screenContents().split("\n");  
        assertEquals("$20.00", lines[7].trim());    
        // switch to payment
        app.touch(3,3); 
        lines = app.screenContents().split("\n");  
        assertEquals("[123456789]", lines[6].trim());
        assertEquals("Scan Now", lines[9].trim());  
        // Make Payments
        app.touch(2,2);  // Pay $1.50
        app.touch(3,3); // switch to balance
        lines = app.screenContents().split("\n");  
        assertEquals("$18.50", lines[7].trim());         
    }

    @After
    public void tearDown()
    {
    }
}
