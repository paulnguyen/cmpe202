/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

import java.util.HashMap;

/**
 * Authentication Proxy for App Controller
 */
public class Device implements IApp, IPinAuthObserver {
    
    private static Device theDevice = null;   
    private boolean fourPin = true ;
    private boolean sixPin = false ;
    private String pin = "" ; 
    private HashMap<String, String> props = new HashMap<String, String>() ;

    private IApp app ;
    private KeyPad kp ;
    private Passcode pc ;
    private PinScreen ps ;
    private Spacer sp ;
    private boolean authenticated = false ;
    private PinEntryMachine pm ;

    public static final int screen_frame_header = 3 ;
    public static final int portrait_screen_width = 15 ;
    public static final int portrait_screen_length = 10 ;
    public static final int landscape_screen_width = 32 ;
    public static final int landscape_screen_length = 6 ;

    public enum ORIENTATION_MODE {
        PORTRAIT, LANDSCAPE
    }

    private ORIENTATION_MODE device_orientation_state ;

    public ORIENTATION_MODE getDeviceOrientation() {
        return this.device_orientation_state ;
    }

    public void setPortraitOrientation() {
        this.device_orientation_state = ORIENTATION_MODE.PORTRAIT ;
    }

    public void setLandscapeOrientation() {
        this.device_orientation_state = ORIENTATION_MODE.LANDSCAPE ;
    }

    private Device() { }

    /** Debug Device State */
    public static void debug()
    {
        Device d = Device.getInstance() ;
        System.err.println( "============================================" ) ;
        System.err.println( "--------- D E V I C E  S T A T E  ----------" ) ;
        System.err.println( "============================================" ) ;
        System.err.println( "Pin Option    = " + d.getPinOption() ) ;
        System.err.println( "Stored Pin    = " + d.getPin() ) ;
        System.err.println( "Authenticated = " + d.isAuthenticated() ) ;
        System.err.println( "Orientation   = " + d.getDeviceOrientation() ) ;
        System.err.println( "API URL       = " + d.getProps("apiurl") ) ;
        System.err.println( "API KEY       = " + d.getProps("apikey") ) ;
        System.err.println( "API Register  = " + d.getProps("register") ) ;
        System.err.println( "============================================" ) ;
    }

    /** Get/Set Device Secured Enclave for Apps **/
    public String getProps(String key) {
        return props.get(key) ;
    }

    public void setProps(String key, String value) {
        props.put(key, value) ;
    }

    /**
     * Get Current Auth State
     * @return Auth T/F
     */
    public String isAuthenticated() {
        return Boolean.toString( authenticated ) ;
    }    

    /**
     * Return the current Pin Option:
     *  0 = User Chosed No Pin
     *  4 = User Chosed 4-digit Pin
     *  6 = User Chosed 6-digit Pin
     * @return Pin Option
     */
    public int getPinOption() {
        if ( fourPin )
            return 4 ;
        else if ( sixPin )
            return 6 ;
        else
            return 0 ;
    }

    /**
     * Get Current Pin
     * @return Pin
     */
    public String getPin() {
        return pin ;
    }


    /**
     * Set Pin
     * @param p New Pin
     */
    private void setPin( String p ) {
        pin = p ;
        int len = p.length() ;
        switch ( len ) {
            case 0:
                fourPin = false ;
                sixPin = false ;              
            case 4:
                fourPin = true ;
                sixPin = false ;
                break ;
            case 6:
                fourPin = false ;
                sixPin = true ;
                break ;
            default:
                fourPin = false ;
                sixPin = false ;
        }
    }

    /**
     * Device Reset Pin  
     */
    private void clearPin()
    {
        this.pin = "" ;
    }

    /**
     * Get Singleton Instance
     * @return Reference to Current Device Config (Create if none exists)
     */
    public synchronized static Device getInstance() {
        if (theDevice == null) {
            return getNewInstance( "1234" ) ;
        }
        else
            return theDevice;
    }

    /**
     * Get New Instance 
     * @return Reference to Device (Create New Singleton)
     */
    public synchronized static Device getNewInstance() {
        return getNewInstance( "1234" ) ;
    }

    public synchronized static Device getNewInstance( String pin ) {

        theDevice = new Device() ;
        theDevice.setPin( pin ) ;

        // Check for Properties from Command Line
        // REF: https://www.baeldung.com/java-system-get-property-vs-system-getenv
        // System.err.println( System.getProperty( "apiurl" ) ) ;
        // System.err.println( System.getProperty( "apikey" ) ) ;
        // System.err.println( System.getProperty( "register" ) ) ;

        String apiurl = System.getProperty( "apiurl", "http://localhost:3000" ) ;
        String apikey = System.getProperty( "apikey", "2742a237475c4703841a2bf906531eb0" ) ;
        String register = System.getProperty( "register", "5012349" ) ;    
        theDevice.setProps( "apiurl", apiurl ) ;
        theDevice.setProps( "apikey", apikey ) ;
        theDevice.setProps( "register", register ) ;

        // Setup UI and Start the App
        theDevice.startUp() ;

        return theDevice ;
    }

    public synchronized static Device getNewInstance( String pin, String url ) {
        if (theDevice == null) {
            theDevice = getNewInstance( "1234" ) ;
            theDevice.setProps( "apiurl", url ) ;
        }
        debug() ;
        return theDevice ;
    }

    /**
     * Device Starup Process.  
     * Starts Up with Default 4-Pin Option
     */
    public void startUp()
    {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        sp = new Spacer() ;
        ps = new PinScreen() ;
        pm = new PinEntryMachine() ;

        // setup the composite pattern
        ps.addSubComponent( pc ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;

        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;
        ((IKeyPadSubject)kp).attach( pm ) ;
        ((IPinAuthSubject)pm).registerObserver(this) ;

        // get app controller reference
        app = AppController.getNewInstance() ;   

        // startup in portrait
        this.device_orientation_state = ORIENTATION_MODE.PORTRAIT ;
    }

    /**
    * Switch to Landscape View
    */
    public void landscape() {
        if ( authenticated )
            app.landscape() ;
    }

    /**
     * Switch to Portait View
     */
    public void portrait() {
        if ( authenticated )
            app.portrait() ;
    }

    /**
     * User Touch at X,Y Coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public void touch(int x, int y) {
        if ( authenticated )
            app.touch(x, y) ;
        else
            ps.touch(x, y) ;
    }

    /**
     * Display Screen Contents to Terminal
     */
    public void display() {
        System.out.println( screenContents() ) ;
    }

    /**
     * Get Class Name of Screen
     * @return Class Name of Current Screen
     */
    public String screen() {
        if ( authenticated )
            return app.screen() ;
        else
            return ps.name() ;
    }

    /**
     * Get Screen Contents as a String
     * @return Screen Contents of Current Screen
     */
    public String screenContents() {
        if ( authenticated ) {
            return app.screenContents() ;
        } else {
            String out = "" ;
            out = "----------------\n" ;
            out += "   " + ps.name() + "  \n" ;
            out += "----------------\n\n\n" ;
            out += ps.display() ;
            out += "\n\n\n----------------\n" ;
            return out ;
        }
    }


    /**
     * Select a Menu Command
     * @param c Menu Option (A, B, C, E, or E)
     */
    public void execute( String c ) {
        if ( authenticated )
            app.execute( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        if ( authenticated )
            app.prev() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        if ( authenticated )
            app.next() ;
    }

    /**
     * Receive Authenticated Event from Authenticator
     */
    public void authEvent() {
        this.authenticated = true ;
    }



}
