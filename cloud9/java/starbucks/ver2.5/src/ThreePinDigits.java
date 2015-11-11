
public class ThreePinDigits implements IPinState
{
    IPinStateMachine machine ;

    public ThreePinDigits( IPinStateMachine m )
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
