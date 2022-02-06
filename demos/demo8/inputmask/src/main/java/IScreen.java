/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

public interface IScreen {

    /**
     * Send key entry events to screen.
     * @param ch Input key enterred by user.
     */
    void key(String ch);

    /**
     * Displays screen components.
     * @return Screen contents as a string of lines.
     */
    String display();

    /**
     * Returns name of screen.
     * @return Name of current screen.
     */
    String name();

}
