

public class AppController
{

    private IScreen current ;
    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private KeyPad kp;
    private Passcode pc;
    private PinScreen ps ;
    private Spacer sp ;
    private Frame app ;

    public AppController()
    {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        ps = new PinScreen() ;
        sp = new Spacer() ;
        // setup the composite pattern
        ps.addSubComponent( pc ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;
        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;
        current = ps ;
        app = new Frame( ps ) ;
        mycards = new MyCards() ;
        store = new Store() ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        app.setScreen ( "A", mycards ) ;
        app.setScreen ( "B", payments ) ;
        app.setScreen ( "C", rewards ) ;
        app.setScreen ( "D", store ) ;
    }

    public void touch(int x, int y)
    {
        app.touch(x,y) ;
    }
    
    public void display()
    {
        app.display() ;
    }
    
    public void execute( String c )
    {
        app.cmd( c ) ;
    }
    
}
