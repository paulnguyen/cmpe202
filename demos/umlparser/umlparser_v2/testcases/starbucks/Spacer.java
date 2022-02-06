/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Spacer "Blank Line" Component */
public class Spacer implements IDisplayComponent, ITouchEventHandler {
    ITouchEventHandler nextHandler ;

    /**
     * Return A Black "Spacer"
     * @return [description]
     */
    public String display() {
        return "" ;
    }

    /**
     * Add Sub Component. -- Not used.
     * @param c Component.
     */
    public void addSubComponent( IDisplayComponent c ) {
        System.err.println( "Add Sub Component: " + c ) ;
    }

    /**
     * Handle Touch Event -- Pass on to next in the chain
     * @param x Touch X
     * @param y Touch Y
     */
    public void touch(int x, int y) {
        if ( nextHandler != null )
            nextHandler.touch(x, y) ;
    }

    /**
     * Set Next Handler in the Chain
     * @param next Handler Object for Touch Events
     */
    public void setNext( ITouchEventHandler next) {
        nextHandler = next ;
    }

}
