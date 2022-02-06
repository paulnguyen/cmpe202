/**
 * (c) Copyright 2018 Paul Nguyen. All Rights Reserved
 *
 * @author  Paul Nguyen
 * @version 3.0
 * @since   2018-08-01
 *
 */


/*
    Sample Program Demonstrating the use of Patterns for an Input Mask
    Uses java.io.Console for Screen output and input.

    ref: https://docs.oracle.com/javase/7/docs/api/java/io/Console.html

*/

import java.io.Console;

/**
 * Main Entry Point.
 */
final class Main {

    /**
     * Prevent Construction.
     */
    private Main() {
        // Utility Class
    }

    /**
     * Main App Entry Point.
     * @param args No args expected.
     */
    public static void main(final String[] args) {
        App app = new App();
        Console c = System.console();
        for (;;) {
            System.out.print("\033[H\033[2J"); // clear the screen
            System.out.flush();
            System.out.println(app.display());
            System.out.print("Key (Digit or X to Delete) => ");
            String ch = c.readLine();
            app.key(ch);
        }
    }
}
