/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Card Number State.
 */
public class CardNumState implements IKeyEntryState {
    /** Num Keys Enterred so Far. */
    private int numKeys = 0;
    /** View State of Card Number. */
    private String number = "";
    /** Reference to State Machine. */
    private StateMachineController sm;
    /** Max Digits. */
    private static final int maxdigits = 16;

    /**
     * Next Key Input.
     * @param key Next Input Key Digit or "X"
     */
    public void key(final String key) {

        if (key.equalsIgnoreCase("X") && numKeys > 0) {
            numKeys--;
            number = number.substring(0, number.length() - 1);
        } else if (key.equalsIgnoreCase("X") && numKeys == 0) {
            numKeys = 0;
        } else {
            numKeys++;
            number += key;
        }

        sm.updateView(number, StateMachineController.STATES.CARD_NUM);

        if (numKeys == maxdigits) {
            sm.setNextState(StateMachineController.STATES.CARD_EXP);
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
