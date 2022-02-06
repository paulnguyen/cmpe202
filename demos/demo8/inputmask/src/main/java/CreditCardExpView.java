/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Credit Card Expiration Date View.
 */
public class CreditCardExpView implements IDisplayComponent, IKeyEventHandler {

    /** Next Event Handler in Chain. */
    private IKeyEventHandler nextHandler;
    /** View State of Expiration Date. */
    private String date = "";

    /**
     * Set Reference to Next Handler.
     * @param next Next Event Handler.
     */
    public void setNext(final IKeyEventHandler next) {
        this.nextHandler = next;
    }

    /**
     * Display View State.
     * @return Digits for CVC.
     */
    public String display() {
        return "[" + date + "]";
    }

     /**
     * Event Change Update Message.
     * @param num   Number to update View State.
     * @param state Targeted View State for Message.
     */
    public void update(final String num,
                       final StateMachineController.STATES state) {
        if (state == StateMachineController.STATES.CARD_EXP) {
            this.date = num;
        } else if (nextHandler != null) {
            nextHandler.update(num, state);
        }
    }

    /**
     * Unused, but required for Display Component Interface.
     * @param c Sub Component to add.
     */
    public void addSubComponent(final IDisplayComponent c) {
        return; // do nothing
    }

}
