/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Store Screen */
public class Store extends Screen
{

   /**
     * Constructor
     */
    public Store() {

    }

    /**
     * Return Screen Contents
     * @return Map Screen Sample Content
     */
    public String display() {
        return "         X\n   X\n       X\n      X\n  X\n           X\n  X" ;
    }

    /**
     * Handle Touch Event -- Not Used.
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y) {
       System.err.println( "X: " + x + " Y: " + y ) ;
    }



}
