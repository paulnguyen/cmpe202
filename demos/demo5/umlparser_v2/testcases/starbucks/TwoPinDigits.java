/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** To Pin Digits State */
public class TwoPinDigits implements IPinState
{
    IPinStateMachine machine ;


    /**
     * Constructor
     * @param  m Reference to State Machine
     */    
    public TwoPinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /** Backspace Event */
    public void backspace() {
        machine.setStateOnePinDigit( null );
    }

    /**
     * Number Event
     * @param digit Digit pressed
     */
    public void number( String digit ) {
        machine.setStateThreePinDigits( digit ) ;
    }

    /** Valid Pin Event */
    public void validPin() {

    }

    /** Invalid Pin Event */
    public void invalidPin() {

    }

}
