/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Credit Card Number View.
 */
public class CreditCardNumView implements IDisplayComponent, IKeyEventHandler {

    /** Next Event Handler in Chain. */
    private IKeyEventHandler nextHandler;
   /** View State of Card Number. */
     private String number = "";

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
        return "[" + number + "]";
    }

    /**
     * Event Change Update Message.
     * @param num   Number to update View State.
     * @param state Targeted View State for Message.
     */
    public void update(final String num,
                       final StateMachineController.STATES state) {
        if (state == StateMachineController.STATES.CARD_NUM) {
            this.number = num;
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

