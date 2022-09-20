/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Three Pin Digit State */
public class ThreePinDigits implements IPinState
{
    IPinStateMachine machine ;

    /**
     * Constructor
     * @param  m Reference to State Machine
     */
    public ThreePinDigits( IPinStateMachine m )
    {
        this.machine = m ;
    }

    /** Backspace Event */
    public void backspace() {
        machine.setStateTwoPinDigits( null ) ;
    }

    /**
     * Number Event
     * @param digit Digit pressed
     */
    public void number( String digit ) {
        machine.setStateFourPinDigits( digit ) ;
    }

    /** Valid Pin Event */
    public void validPin() {

    }

    /** Invlid Pin Event */
    public void invalidPin() {

    }

}
