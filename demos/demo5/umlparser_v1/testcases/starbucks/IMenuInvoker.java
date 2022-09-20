/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Menu Invoker Interfaces */
public interface IMenuInvoker
{
    /**
     * Set Command for Invoker
     * @param c Command Object
     */
    void setCommand( IMenuCommand c ) ;

    /** Invoke Menu Function */
    void invoke() ;
}
