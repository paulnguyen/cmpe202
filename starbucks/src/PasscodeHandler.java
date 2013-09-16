/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class PasscodeHandler implements TouchEventHandler
{
    private TouchEventHandler nextHandler ;
    private Passcode passcode ;

    public PasscodeHandler(Passcode pc)
    {
        this.passcode = pc ;
        this.nextHandler = null ;
    }

    public void setNext( TouchEventHandler next )
    {
        this.nextHandler = next ;
    }

    public void touch(int x, int y)
    {
        if ( this.nextHandler != null )
            this.nextHandler.touch( x, y ); ;
    }
}
