/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

import java.util.ArrayList;

/**
 * Main Screen to Display UI Views & Take Input from User.
 */
public class Screen implements IScreen, IDisplayComponent {

    /** List of UI components in the Screen. */
    private ArrayList<IDisplayComponent>
        components = new ArrayList<IDisplayComponent>();
    /** Entry point to chain of View components
        listining for Key chage display events. */
    private IKeyEventHandler chain;
    /** State Machine Controller for Input Processing. */
    private StateMachineController sm;

    /** Default Constructor. */
    public Screen() {
        // no constructor elements
    }

    /**
     * Key Input to Screen.
     * @param ch Key as 0-9 or X.
     */
    public void key(final String ch) {
        sm.key(ch);
    }

    /**
     * Pattern Method to add View Components to Screen.
     * @param c View Component to Add.
     */
    public void addSubComponent(final IDisplayComponent c) {
        components.add(c);
        if (components.size() == 1) {
            chain = (IKeyEventHandler) c;
        } else {
            IKeyEventHandler prev = (IKeyEventHandler)
                components.get(components.size() - 2);
            prev.setNext((IKeyEventHandler) c);
        }
    }

    /**
     * Pattern Method to Display All Screen Components in Hierarchy.
     * @return Lines of Text to Display to Terminal.
     */
    public String display() {
        String value = "";
        StringBuffer buf = new StringBuffer();
        for (IDisplayComponent c : components) {
            buf.append(value);
            buf.append(c.display());
        }
        value = buf.toString();
        return value;
    }

    /**
     * Get Name of Screen.
     * @return Name of Screen.
     */
    public String name() {
        return (this.getClass().getName());
    }

    /**
     * Set Association to State Machine.
     * @param m [description]
     */
    public void setStateMachine(final StateMachineController m) {
        this.sm = m;
        this.sm.setKeyEventHandler(chain);
    }

}
