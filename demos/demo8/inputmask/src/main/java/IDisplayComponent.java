/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Interface for Display Components.
 */
public interface IDisplayComponent {

    /**
     * Display all UI commponents on a Screen.
     * @return String to display.
    */
    String display();

    /**
     * Add a Nested / Subcomponent.
     * @param c Component to add.
     */
    void addSubComponent(IDisplayComponent c);

}
