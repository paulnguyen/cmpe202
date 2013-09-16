/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class NoPinDigits implements PinState
{
    PinStateMachine machine ;

    public NoPinDigits( PinStateMachine m )
    {
        this.machine = m ;
    }

    public void backspace() {
    }

    public void number( String digit ) {
        machine.setStateOnePinDigit( digit ) ;
    }

    public void validPin() {
    }

    public void invalidPin() {
    }

}
