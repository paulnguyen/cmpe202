/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {
    /** Current screen. */
    private Screen screen;
    /** Credit Card Number Input. */
    private CreditCardNumView num;
    /** Credit Card Expired Date Input. */
    private CreditCardExpView exp;
    /** Credit Card CVC Input. */
    private CreditCardCVCView cvc;
    /** View Controller. */
    private StateMachineController sm;
    /** Credit Card Number Input Mask. */
    private InputMaskCardNum numMask;
    /** Credit Card Expired Date Input Mask. */
    private InputMaskCardExp expMask;

    /** Default Constructor. */
    public App() {

        screen = new Screen();
        num = new CreditCardNumView();
        exp = new CreditCardExpView();
        cvc = new CreditCardCVCView();

        // add input mask decorators
        numMask = new InputMaskCardNum(num);
        expMask = new InputMaskCardExp(exp);

        // need to build the ui components & event chain in the view ...
        screen.addSubComponent(numMask);
        screen.addSubComponent(expMask);
        screen.addSubComponent(cvc);

        // before the state machine (todo: remove order requirement)
        sm = new StateMachineController();
        screen.setStateMachine(sm);

    }

    /**
     * Display screen output.
     * @return lines for screen.
    */
    public String display() {
        String output = "";
        output += "========================================\n";
        output += "         Input Mask Test Screen         \n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += " " + screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        output += " " + sm.debug();
        output += "\n";
        output += "========================================\n";
        return output;
    }

    /**
     * Input key.
     * @param ch key (digits 0-9) or 'X'
     */
    public void key(final String ch) {
        screen.key(ch);
    }

}
