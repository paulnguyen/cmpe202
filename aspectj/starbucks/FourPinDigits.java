

public class FourPinDigits implements IPinState
{
    IPinStateMachine machine ;

    public FourPinDigits( IPinStateMachine m )
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
