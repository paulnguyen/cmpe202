/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Interface for Key Event Handlers.
 */
public interface IKeyEventHandler {

    /**
     * Send key entry udpates to view.
     * @param num   Current digits enterred so far.
     * @param state Target State to receive the event.
     */
    void update(String num, StateMachineController.STATES state);

    /**
     * Set next handler in event chain.
     * @param next Next handler in the chain.
     */
    void setNext(IKeyEventHandler next);

}
