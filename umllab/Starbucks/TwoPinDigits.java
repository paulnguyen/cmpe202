/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class TwoPinDigits implements PinState
{
    PinStateMachine machine ;

    public TwoPinDigits( PinStateMachine m )
    {
        this.machine = m ;
    }

    public void backspace() {
        machine.setStateOnePinDigit( null );
    }

    public void number( String digit ) {
        machine.setStateThreePinDigits( digit ) ;
    }

    public void validPin() {

    }

    public void invalidPin() {

    }

}
