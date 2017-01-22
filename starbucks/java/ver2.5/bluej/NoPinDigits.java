
public class NoPinDigits implements IPinState
{
    IPinStateMachine machine ;

    public NoPinDigits( IPinStateMachine m )
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
