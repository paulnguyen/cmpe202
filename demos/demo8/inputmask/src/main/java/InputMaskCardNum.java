/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */

/**
 * Input Mask Decorator for Card Number.
 */
public class InputMaskCardNum implements IDisplayComponent, IKeyEventHandler {

    /** Card Number View. */
    private CreditCardNumView view;

    /** First Space Split Start. */
    private static final int SPACE1_SPLIT_START = 0;
    /** First Space Split End. */
    private static final int SPACE1_SPLIT_END = 5;
    /** First Space Min Chars. */
    private static final int SPACE1_MIN = 6;
    /** First Space Max Chars. */
    private static final int SPACE1_MAX = 10;

    /** Second Space Split Start. */
    private static final int SPACE2_SPLIT_START = 5;
    /** Second Space Split End. */
    private static final int SPACE2_SPLIT_END = 9;
    /** Second Space Min Chars. */
    private static final int SPACE2_MIN = 10;
    /** Second Space Max Chars. */
    private static final int SPACE2_MAX = 14;

    /** Third Space Split Start. */
    private static final int SPACE3_SPLIT_START = 9;
    /** Third Space Split End. */
    private static final int SPACE3_SPLIT_END = 13;

    /**
     * Constructor.
     * @param  c View Component.
     */
    public InputMaskCardNum(final CreditCardNumView c) {
        this.view = c;
    }

    /**
     * Display Content Masked.
     * @return String Content.
     */
    public String display() {
        String value = view.display();

        if (value.equals("[]")) {
            return "[4444 4444 4444 4444]   ";
        }

        String decorated = value;
        int len = value.length();

        if (len >= SPACE1_MIN && len < SPACE1_MAX) {
            // 012345  0123456789
            // [1234], [12345678] => [1234 5678]
             decorated = value.substring(SPACE1_SPLIT_START,
                                         SPACE1_SPLIT_END)
                         + " "
                         + value.substring(SPACE1_SPLIT_END, len);
        }
        if (len >= SPACE2_MIN && len < SPACE2_MAX) {
            // 01234567890123
            // [123456789012] => [1234 5678 9012]
             decorated =    value.substring(SPACE1_SPLIT_START,
                                            SPACE1_SPLIT_END)
                            + " "
                            + value.substring(SPACE2_SPLIT_START,
                                            SPACE2_SPLIT_END) + " "
                            + value.substring(SPACE3_SPLIT_START, len);
        }
        if (len >= SPACE2_MAX) {
            // 012345678901234567
            // [1234567890123456] => [1234 5678 9012 3456]
             decorated =    value.substring(SPACE1_SPLIT_START,
                                            SPACE1_SPLIT_END)
                            + " "
                            + value.substring(SPACE2_SPLIT_START,
                                            SPACE2_SPLIT_END)
                            + " "
                            + value.substring(SPACE3_SPLIT_START,
                                            SPACE3_SPLIT_END)
                            + " "
                            + value.substring(SPACE3_SPLIT_END, len);
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
