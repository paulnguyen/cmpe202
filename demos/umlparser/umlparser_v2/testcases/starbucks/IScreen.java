/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Screen Interface */
public interface IScreen
{

    /**
     * Send touch events to screen
     * @param x Touch X
     * @param y Touch Y
     */
    void touch(int x, int y) ;              

    /**
     * Displays screen components
     * @return Return Screen Contents
     */
    String display() ;       

    /**
     * Returns name of screen
     * @return Screen Name
     */
    String name() ;                         

    /**
     * Navigate to next screen
     */
    void next() ;                           

    /**
     * Navigate to previous screen
     */
    void prev() ;      

    /**
     * Set next screen with action name
     * @param s Screen
     * @param n Action
     */
    void setNext(IScreen s, String n ) ;    

    /**
     * Set previous screen with action name
     * @param s Screen
     * @param n Action
     */
    void setPrev(IScreen s, String n ) ;    

}
