/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Menu Command */
public class MenuCommand implements IMenuCommand
{
    IMenuReceiver target ;
    
    /** Execute Command */
    public void execute() 
    {
        target.doAction() ;
    }
    
    /**
     * Set Receiver of Command
     * @param t Target Receiver
     */
    public void setReceiver( IMenuReceiver t ) 
    {
        target = t ;
    }
}
