
public class PinScreen implements IScreen
{

    private KeyPad kp;
    private Passcode pc;
    private ITouchEventHandler chain ;

    public PinScreen()
    {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        kp.setNext( pc ) ;
        chain = kp ;
    }

    public void touch(int x, int y) {
        chain.touch(x, y) ;
    }
    public String display() { return "" ; }

}
