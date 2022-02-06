/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Interface for Key States.
 */
public interface IKeyEntryState {

    /**
     * Digit Key Enterred.
     * @param key Digit (0-9) or 'X'.
     */
    void key(String key);

    /**
     * Set Reference to State Machine Context.
     * @param m Reference to State Machine.
     */
    void setStateMachine(StateMachineController m);

    /**
     * Number of Keys Captured so far.
     * @return Count of Keys.
     */
    int getNumKeys();

}
