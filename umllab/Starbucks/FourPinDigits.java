/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class FourPinDigits implements PinState
{
    PinStateMachine machine ;

    public FourPinDigits( PinStateMachine m )
    {
        this.machine = m ;
    }

    public void backspace() {

    }

    public void number( String digit ) {

    }

    public void validPin() {

    }

    public void invalidPin() {
        machine.setStateNoPinDigits() ;
    }

}
