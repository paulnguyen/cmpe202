/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class ThreePinDigits implements PinState
{
    PinStateMachine machine ;

    public ThreePinDigits( PinStateMachine m )
    {
        this.machine = m ;
    }

    public void backspace() {
        machine.setStateTwoPinDigits( null ) ;
    }

    public void number( String digit ) {
        machine.setStateFourPinDigits( digit ) ;
    }

    public void validPin() {

    }

    public void invalidPin() {

    }

}
