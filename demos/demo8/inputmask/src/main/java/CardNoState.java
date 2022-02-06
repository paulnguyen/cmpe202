/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * No State Place Holder.
 */
public class CardNoState implements IKeyEntryState {
    /** Reference to State Machine. */
    private StateMachineController sm;

    /**
     * Next Key Input.
     * @param key Next Input Key Digit or "X"
     */
    public void key(final String key) {
        if (key.equalsIgnoreCase("X")) {
            sm.setNextState(StateMachineController.STATES.CARD_CVC);
            sm.key("X");
        }
    }

    /**
     * Setup Reference to State Machine.
     * @param m State Machine
     */
    public void setStateMachine(final StateMachineController m) {
        this.sm = m;
    }

   /**
     * Get the Number of Keys Enterred so far.
     * @return Num Keys
     */
    public int getNumKeys() {
        return 0;
    }

}
