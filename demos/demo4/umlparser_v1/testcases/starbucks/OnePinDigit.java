/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** One Pig Digit State */
public class OnePinDigit implements IPinState
{
    IPinStateMachine machine ;

    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public OnePinDigit( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /** Backspace Event */
    public void backspace() {
        machine.setStateNoPinDigits() ;
    }

   /**
     * Number Event
     * @param digit Digit pressed
     */    
    public void number( String digit ) {
        machine.setStateTwoPinDigits( digit ) ;
    }

    /** Valid Pin Event */
    public void validPin() {

    }

    /** Invalid Pin Event */
    public void invalidPin() {

    }
}
