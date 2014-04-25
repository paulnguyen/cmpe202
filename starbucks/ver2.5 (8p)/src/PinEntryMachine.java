
public class PinEntryMachine implements IPinStateMachine, IKeyPadObserver, IPinAuthSubject
{

    // get name of current state for unit testing
    public String getCurrentState()
    {
        return state.getClass().getName() ;
    }

    // Pin Domain Object
    private String pin = "1234" ;
    private boolean authenticated = false ;
    private int pinCount=0 ;
    private IPinAuthObserver auth ; // single observer 

    // pin machine states
    private NoPinDigits pin0 ;
    private OnePinDigit pin1 ;
    private TwoPinDigits pin2 ;
    private ThreePinDigits pin3 ;
    private FourPinDigits pin4 ;

    // current state
    private IPinState state ;

    // pin captured so far
    private String d1, d2, d3, d4 ;

    public PinEntryMachine( )
    {
        pin0 = new NoPinDigits( this ) ;
        pin1 = new OnePinDigit( this ) ;
        pin2 = new TwoPinDigits( this ) ;
        pin3 = new ThreePinDigits( this ) ;
        pin4 = new FourPinDigits( this ) ;
        this.state = pin0 ;
    }

    public void backspace() {
        this.state.backspace() ;
    }

    public void number( String digit ) {
        this.state.number( digit ) ;
    }

    public void validPin() {
        this.state.validPin() ;
    }

    public void invalidPin() {
        this.state.invalidPin() ;
    }

    public void setStateNoPinDigits()
    {
        this.pinCount = 0 ;
        this.state = pin0 ;
        this.d1 = "" ;
        this.d2 = "" ;
        this.d3 = "" ;
        this.d4 = "" ;
        debug() ;
    }

    public void setStateOnePinDigit( String digit )
    {
        this.pinCount = 1 ;
        this.state = pin1 ;
        if ( digit != null )
            this.d1 = digit ;
        else
            this.d2 = "" ;
        debug() ;
    }

    public void setStateTwoPinDigits( String digit )
    {
        this.pinCount = 2 ;
        this.state = pin2 ;
        if ( digit != null )
            this.d2 = digit ;
        else
            this.d3 = "" ;
        debug() ;
    }

    public void setStateThreePinDigits( String digit )
    {
        this.pinCount = 3 ;
        this.state = pin3 ;
        if ( digit != null )
            this.d3 = digit ;
        else
            this.d4 = "" ;
        debug() ;
    }

    public void setStateFourPinDigits( String digit )
    {
        this.pinCount = 4 ;
        this.state = pin4 ;
        if ( digit != null )
        {
            this.d4 = digit ;
            debug() ;
            System.out.println( "Authenticating..." ) ;
            if ( pin.equals( d1+d2+d3+d4 ) )
            {
                System.out.println( "Successful Login!" ) ;
                this.authenticated = true ;
                notifyObserver() ;
            }
            else
            {
                System.out.println( "Login Failed!" ) ;
                setStateNoPinDigits() ;
            }
        }
    }

    public void keyEventUpdate( int c, String key ) 
    {
        System.out.println( "Key: " + key ) ;
        if ( key.equals(" ") )
        /* nothing */ ;
        else if ( key.equals("X") )
            backspace() ;
        else
            number( key ) ;        
    }    

    public void registerObserver( IPinAuthObserver obj ) 
    {
        this.auth = obj ;
    }

    public void removeObserver( IPinAuthObserver obj ) 
    {
        this.auth = null ;
    }

    public void notifyObserver( ) 
    {
        if ( this.auth != null )
            this.auth.authEvent() ;
    }

    private void debug()
    {
        System.out.println( "Current State: " + state.getClass().getName() ) ;
        System.out.println( "D1 = " + d1 ) ;
        System.out.println( "D2 = " + d2 ) ;
        System.out.println( "D3 = " + d3 ) ;
        System.out.println( "D4 = " + d4 ) ;
    }

}
