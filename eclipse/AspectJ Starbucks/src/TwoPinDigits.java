
public class TwoPinDigits implements IPinState
{
    IPinStateMachine machine ;

    public TwoPinDigits( IPinStateMachine m )
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
