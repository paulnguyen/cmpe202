

public class AppController
{

    IScreen current ;
    private KeyPad kp;
    private Passcode pc;
    private PinScreen ps ;

    public AppController()
    {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        ps = new PinScreen() ;
        // setup the composite pattern
        ps.addSubComponent( (IDisplayComponent) pc ) ;
        ps.addSubComponent( (IDisplayComponent) kp ) ;
        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;
        current = ps ;
    }


    public void touch(int x, int y)
    {
        current.touch(x,y) ;

    }
    
    public void display()
    {
        System.out.println( "Screen Title\n" ) ;
        System.out.println( current.display() ) ;
        System.out.println( "[1] [2] [3] [4]" ) ;
        
    }
}


