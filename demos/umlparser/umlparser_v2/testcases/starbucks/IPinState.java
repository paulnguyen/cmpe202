/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/**
 * Pin State Interfaces
 */
public interface IPinState
{
    /** Backspace Event */
    void backspace() ;

    /**
     * Number Event
     * @param digit Digit/Key Pressed
     */
    void number( String digit ) ;

    /** Valid Pin Event */
    void validPin() ;

    /** Invalid Pin Event */
    void invalidPin() ;
}
