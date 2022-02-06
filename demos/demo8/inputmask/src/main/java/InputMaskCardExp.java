/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Input Mask Decorator for Card Expiration Date.
 */
public class InputMaskCardExp implements IDisplayComponent, IKeyEventHandler {

    /** Card Exp View. */
    private CreditCardExpView view;
    /** Max Digits for Date Numbers. */
    private static final int maxdigits = 4;
    /** Date Separator Split Post. */
    private static final int split = 3;

    /**
     * Constructor.
     * @param  c View Component.
     */
    public InputMaskCardExp(final CreditCardExpView c) {
        this.view = c;
    }

    /**
     * Display Content Masked.
     * @return String Content.
     */
    public String display() {
        String value = view.display();

        if (value.equals("[]")) {
            return "[MM/YY]   ";
        }

        String decorated = value;
        int len = value.length();

        if (len >= maxdigits) {
            // 0123  01234  012345
            // [12], [123], [1234]
             decorated = value.substring(0, split)
                        + "/" + value.substring(split, len);
        }

        return decorated + "  ";
    }

    /**
     * Passthru to Component.
     * @param c Componenr.
     */
    public void addSubComponent(final IDisplayComponent c) {
        this.view.addSubComponent(c);
    }

    /**
     * Passthru to Component.
     * @param num   Number.
     * @param state State.
     */
    public void update(final String num,
                        final StateMachineController.STATES state) {
        this.view.update(num, state);
    }

    /**
     * Passthru to Component.
     * @param next Next Handler.
     */
    public void setNext(final IKeyEventHandler next) {
        this.view.setNext(next);
    }

}
