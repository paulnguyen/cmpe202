

public class AppController
{

    private IScreen current ;
    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doExit ;    
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
        app = new Frame( ps ) ;
        mycards = new MyCards() ;
        store = new Store() ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        
        // setup the composite pattern
        ps.addSubComponent( pc ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;
        
        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;
        current = ps ;
        
        // setup command pattern
        displayMyCards  = new MenuCommand() ;
        displayPayments = new MenuCommand() ;
        displayRewards  = new MenuCommand() ;
        doExit          = new MenuCommand() ;
        displayMyCards.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    app.setCurrentScreen( mycards ) ;
                }
            }
        ) ;
        displayPayments.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    app.setCurrentScreen( payments ) ;
                }
            }
        ) ;
        displayRewards.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                    app.setCurrentScreen( rewards ) ;
                }
            }
        ) ;
        doExit.setReceiver(
            new IMenuReceiver() {
                public void doAction() {
                   System.out.println( "Goodbye!" ) ;
                }
            }
        ) ;        
        app.setMenuItem ( "A", displayMyCards ) ;
        app.setMenuItem ( "B", displayPayments ) ;
        app.setMenuItem ( "C", displayRewards ) ;
        app.setMenuItem ( "D", doExit ) ;
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
