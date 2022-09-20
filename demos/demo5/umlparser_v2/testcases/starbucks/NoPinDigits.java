/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** No Pin Digits State */
public class NoPinDigits implements IPinState
{
    IPinStateMachine machine ;

    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public NoPinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /** Backspace Event */
    public void backspace() {
    }

    /**
     * Number Event
     * @param digit Digit pressed
     */
    public void number( String digit ) {
        machine.setStateOnePinDigit( digit ) ;
    }

    /** Valid Pin Event */
    public void validPin() {
    }

    /** Invalid Pin Event */
    public void invalidPin() {
    }

}
