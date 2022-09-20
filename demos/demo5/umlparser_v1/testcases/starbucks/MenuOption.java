/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Menu Option */
public class MenuOption implements IMenuInvoker
{
    private IMenuCommand cmd ;

    /**
     * Set Command for Menu Option
     * @param c [description]
     */
    public void setCommand( IMenuCommand c ) {
        cmd = c ;
    }

    /** Invoke Menu Option */
    public void invoke() 
    {
        cmd.execute() ;
    }
    
}
