/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * State Machine Controller.
 */
public class StateMachineController {

    /** States Enums. */
    public enum STATES {
        /** State to Gather Card Number. */
        CARD_NUM,
        /** State to Gather Date of Expiration. */
        CARD_EXP,
        /** State to Gather CVC Digits. */
        CARD_CVC,
        /** Place Holder Null State. */
        NO_STATE
    }

    /** Key Event Chain Reference in UI Views. */
    private IKeyEventHandler chain;
    /** Current State. */
    private IKeyEntryState current;
    /** Previous State. */
    private IKeyEntryState previous;
    /** Number Key Entry State. */
    private IKeyEntryState numState;
    /** Expiration Date Key Entry State. */
    private IKeyEntryState expState;
    /** CVC Digits Key Entry State. */
    private IKeyEntryState cvcState;
    /** Beyond Max Keys No State. */
    private IKeyEntryState noState;

    /** Default Constructor. */
    public StateMachineController() {
        numState = new CardNumState();
        expState = new CardExpState();
        cvcState = new CardCVCState();
        noState  = new CardNoState();
        numState.setStateMachine(this);
        expState.setStateMachine(this);
        cvcState.setStateMachine(this);
        noState.setStateMachine(this);
        previous = numState;
        current = numState;
    }

    /**
     * Set Reference to UI Views Key Event Handler Chain.
     * @param handler Entry into UI Views Event Chain.
     */
    public void setKeyEventHandler(final IKeyEventHandler handler) {
        this.chain = handler;
    }

    /**
     * Update the Responsible UI View Element.
     * @param value Key Enterred by User.
     * @param state Target State Machine State for Event.
     */
    public void updateView(final String value, final STATES state) {
        chain.update(value, state);
    }

    /**
     * Screen Key Event to be Processed by State Machine.
     * @param key Chars 0-9 or X.
     */
    public void key(final String key) {
        if (key.matches("([0-9]|X|x)")) {
            this.current.key(key);
        }
    }

    /**
     * Debug Method to Display to Terminal.
     * @return Debug String to Display on Terminal.
     */
    public String debug() {
        String debugline = "";
        debugline += "PREV: " + getPreviousState();
        debugline += "  ";
        debugline += "CURR: " + getCurrentState();
        debugline += "  ";
        debugline += "#: " + current.getNumKeys();
        return debugline;
    }

    /**
     * Used by Individual States to Set Target of Transitions.
     * @param s Next State Enum Value.
     */
    public void setNextState(final STATES s) {
        //System.out.println ("Setting Next State to: " + s);
        previous = current;
        switch (s) {
            case CARD_NUM: current = numState; break;
            case CARD_EXP: current = expState; break;
            case CARD_CVC: current = cvcState; break;
            case NO_STATE: current = noState; break;
            default: current = noState; break;
        }
        System.out.println(current);
    }

    /**
     * Return the Current State.
     * @return Current State.
     */
    public STATES getCurrentState() {
        String name = current.getClass().getName();
        //System.out.println(name);
        if (name.equals("CardNumState")) {
            return STATES.CARD_NUM;
        } else if (name.equals("CardExpState")) {
            return STATES.CARD_EXP;
        } else if (name.equals("CardCVCState")) {
            return STATES.CARD_CVC;
        } else {
            return STATES.NO_STATE;
        }
    }

    /**
     * Return the Previous State.
     * @return Previous State.
     */
    public STATES getPreviousState() {
        String name = previous.getClass().getName();
        //System.out.println(name);
        if (name.equals("CardNumState")) {
            return STATES.CARD_NUM;
        } else if (name.equals("CardExpState")) {
            return STATES.CARD_EXP;
        } else if (name.equals("CardCVCState")) {
            return STATES.CARD_CVC;
        } else {
            return STATES.NO_STATE;
        }
    }

}
