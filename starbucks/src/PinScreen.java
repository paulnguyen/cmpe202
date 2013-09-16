/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class PinScreen implements AppScreen {

    TouchEventHandler eventChain ;
    PinStateMachine pinMachine ;
    Passcode passcodeDisplay ;

    public PinScreen() {
        pinMachine = new PinEntryMachine() ;
        passcodeDisplay = new Passcode() ;
        ((PinEntrySubject) pinMachine).registerObserver(passcodeDisplay) ;
        TouchEventHandler pc = new PasscodeHandler( passcodeDisplay ) ;
        TouchEventHandler kp = new KeyPadHandler( pinMachine ) ;
        pc.setNext(kp);
        this.eventChain = pc ;
    }

    public void touch(int x, int y) {
        eventChain.touch(x,y);
    }

    public String display() {
        passcodeDisplay.display() ;
        String returnVal = "Enter Pin";
        System.out.println(returnVal);
        return returnVal;
    }

    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }

}

