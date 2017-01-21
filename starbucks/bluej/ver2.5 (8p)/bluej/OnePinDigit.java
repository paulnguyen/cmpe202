
public class OnePinDigit implements IPinState
{
    IPinStateMachine machine ;

    public OnePinDigit( IPinStateMachine m )
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
