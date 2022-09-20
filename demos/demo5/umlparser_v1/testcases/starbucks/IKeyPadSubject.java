/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;


/** Key Pad Subject Interface */
public interface IKeyPadSubject
{
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    void attach( IKeyPadObserver obj ) ;

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    void removeObserver( IKeyPadObserver obj ) ;

    /**
     * Trigger Events to Observers
     */
    void notifyObservers() ;
}
