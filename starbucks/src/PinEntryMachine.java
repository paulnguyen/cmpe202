/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

import java.util.ArrayList;

public class PinEntryMachine implements PinStateMachine, PinEntrySubject
{
    // Observers
    private ArrayList<PinEntryObserver> observers ;

    public void registerObserver( PinEntryObserver obj )
    {
        observers.add( obj ) ;
    }

    public void removeObserver( PinEntryObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    public void notifyObservers( )
    {
        for (int i=0; i<observers.size(); i++)
        {
            PinEntryObserver observer = observers.get(i) ;
            observer.update( this.pinCount ) ;
        }
    }

    // get name of current state for unit testing
    public String getCurrentState()
    {
        return state.getClass().getName() ;
    }
    
    // Pin Domain Object
    private Pin pin ;
    private int pinCount=0 ;
    
    // pin machine states
    private NoPinDigits pin0 ;
    private OnePinDigit pin1 ;
    private TwoPinDigits pin2 ;
    private ThreePinDigits pin3 ;
    private FourPinDigits pin4 ;

    // current state
    private PinState state ;

    // pin captured so far
    private String d1, d2, d3, d4 ;

    public PinEntryMachine( )
    {
        observers = new ArrayList<PinEntryObserver>() ;
        pin0 = new NoPinDigits( this ) ;
        pin1 = new OnePinDigit( this ) ;
        pin2 = new TwoPinDigits( this ) ;
        pin3 = new ThreePinDigits( this ) ;
        pin4 = new FourPinDigits( this ) ;
        this.state = pin0 ;
        this.pin = Pin.getInstance() ;
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
        notifyObservers() ;
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
        notifyObservers() ;
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
        notifyObservers() ;
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
        notifyObservers() ;
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
        notifyObservers() ;
        this.state = pin4 ;
        if ( digit != null )
        {
            this.d4 = digit ;
            debug() ;
            System.out.println( "Authenticating..." ) ;
            this.pin.validate( d1+d2+d3+d4 ) ;
            if ( !this.pin.isAuthenticated() )
                  setStateNoPinDigits() ;
        }
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
