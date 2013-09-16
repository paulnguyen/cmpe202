/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class OnePinDigit implements PinState
{
    PinStateMachine machine ;

    public OnePinDigit( PinStateMachine m )
    {
        this.machine = m ;
    }

    public void backspace() {
        machine.setStateNoPinDigits() ;
    }

    public void number( String digit ) {
        machine.setStateTwoPinDigits( digit ) ;
    }

    public void validPin() {

    }

    public void invalidPin() {

    }
}
