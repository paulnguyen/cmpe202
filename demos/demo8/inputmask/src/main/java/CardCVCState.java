/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 *  CVC Card Input State.
 */
public class CardCVCState implements IKeyEntryState {
    /** Num Keys Enterred so Far. */
    private int numKeys = 0;
    /** View State of CVC #. */
    private String cvc = "";
    /** Reference to State Machine. */
    private StateMachineController sm;
    /** Max Digits. */
    private static final int maxdigits = 3;

    /**
     * Next Key Input.
     * @param key Next Input Key Digit or "X"
     */
    public void key(final String key) {
        if (key.equalsIgnoreCase("X") && cvc.length() > 0) {
            numKeys--;
            cvc = cvc.substring(0, cvc.length() - 1);
            sm.updateView(cvc, StateMachineController.STATES.CARD_CVC);
        } else if (key.equalsIgnoreCase("X") && numKeys == 0) {
            sm.setNextState(StateMachineController.STATES.CARD_EXP);
        } else {
            numKeys++;
            cvc += key;
            sm.updateView(cvc, StateMachineController.STATES.CARD_CVC);
        }

        if (numKeys == maxdigits) {
            sm.setNextState(StateMachineController.STATES.NO_STATE);
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


