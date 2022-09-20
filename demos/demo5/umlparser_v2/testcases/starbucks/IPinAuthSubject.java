/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Pin Authentication Subject */
public interface IPinAuthSubject
{
    /**
     * Add a Pin Auth Observer
     * @param obj Observer Object
     */
    void registerObserver( IPinAuthObserver obj ) ;

    /**
     * Remove Observer
     * @param obj Pin AUth Observer to Remove
     */
    void removeObserver( IPinAuthObserver obj ) ;

    /**
     * Broadcast Event to Observers
     */
    void notifyObserver( ) ;
    
}
