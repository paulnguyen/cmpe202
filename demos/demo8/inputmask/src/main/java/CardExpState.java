/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Card Expiration Date State.
 */
public class CardExpState implements IKeyEntryState {
    /** Num Keys Enterred so Far. */
    private int numKeys = 0;
    /** View State of Date. */
    private String date = "";
    /** Reference to State Machine. */
    private StateMachineController sm;
    /** Max Digits. */
    private static final int maxdigits = 4;

    /**
     * Next Key Input.
     * @param key Next Input Key Digit or "X"
     */
    public void key(final String key) {

        if (key.equalsIgnoreCase("X") && numKeys > 0) {
            numKeys--;
            date = date.substring(0, date.length() - 1);
            sm.updateView(date, StateMachineController.STATES.CARD_EXP);
        } else if (key.equalsIgnoreCase("X") && numKeys == 0) {
            sm.setNextState(StateMachineController.STATES.CARD_NUM);
        } else {
            numKeys++;
            date += key;
            sm.updateView(date, StateMachineController.STATES.CARD_EXP);
        }

        if (numKeys == maxdigits) {
            sm.setNextState(StateMachineController.STATES.CARD_CVC);
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
        return numKeys;
    }
}

