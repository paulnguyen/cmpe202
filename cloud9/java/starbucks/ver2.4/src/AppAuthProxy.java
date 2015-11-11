
/**
 * Write a description of class AppAuthProxy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppAuthProxy implements IApp
{
    private IApp app = new AppController() ;
    private KeyPad kp;
    private Passcode pc;
    private PinScreen ps ;
    private Spacer sp ;
    private boolean authenticated = false ;

    public AppAuthProxy()
    {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        sp = new Spacer() ;
        ps = new PinScreen() ;

        // setup the composite pattern
        ps.addSubComponent( pc ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;

        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;       

    }

    public void landscape() 
    { 
        if ( authenticated )
            app.landscape() ; 
    }

    public void portrait()  
    { 
        if ( authenticated )
            app.portrait() ; 
    }      

    public void touch(int x, int y)
    {
        if ( authenticated )
            app.touch(x,y) ;
        else
            ps.touch(x,y) ;
    }

    public void display()
    {
        if ( authenticated )
        {
            app.display() ;
        }
        else
        {
            System.out.println( "----------------" ) ;            
            System.out.println( "   " + ps.getClass().getName() + "  " ) ;
            System.out.println( "----------------\n" ) ;            
            System.out.println( ps.display() ) ;
            System.out.println( "----------------\n" ) ;            
        }
    }

    public void execute( String c )
    {
        if ( authenticated )
            app.execute( c ) ;
    }

}
