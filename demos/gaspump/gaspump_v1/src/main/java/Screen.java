
import java.util.* ;
import java.util.Random ;

public class Screen implements IScreen
{
    // ad message
    private String[] ads = {
        "Join our Rewards Program.", 
        "Hungry? Visit our Snack Bar.", 
        "Save with a Car Wash.",
        "Star Wars Movie Preview.",
        "New on HBO Now.",
        "New iPhone 13 at AT&T.",
        "Macy's Summer Clearance.",
        "Get Your Smog Check Now."
    };
    private String ad = "" ;

    // get random ad
    private String getAd() {
        Random rand = new Random() ;
        int index = rand.nextInt(ads.length) ; 
        return ads[index] ;
    }

    // states
    private State S0 = new State0(this) ;
    private State S1 = new State1(this) ;    
    private State S2 = new State2(this) ;   
    private State S3 = new State3(this) ;   
    private State S4 = new State4(this) ;   
    private State S5 = new State5(this) ;
    private State S6 = new State6(this) ;   
    private State S7 = new State7(this) ;   

    private State current = S0 ;

    public void setState( int new_state ) {
        switch ( new_state ) {
            case 0: current = S0 ; break ;
            case 1: current = S1 ; break ;
            case 2: current = S2 ; break ;
            case 3: current = S3 ; break ;
            case 4: current = S4 ; break ;
            case 5: current = S5 ; break ;
            case 6: current = S6 ; break ;
            case 7: current = S7 ; break ;
        }
    }

    // commands
    private ICommand cmd_a = new ICommand() {
                                public void execute() {
                                    current.doA() ;
                                }
                        } ;
    private ICommand cmd_b = new ICommand() {
                                public void execute() {
                                    current.doB() ;
                                }
                        } ;
    private ICommand cmd_c = new ICommand() {
                                public void execute() {
                                    current.doC() ;
                                }
                        } ;
    private ICommand cmd_d = new ICommand() {
                                public void execute() {
                                    current.doD() ;
                                }
                        } ;
    private ICommand cmd_e = new ICommand() {
                                public void execute() {
                                    current.doE() ;
                                }
                        } ;
    private ICommand cmd_f = new ICommand() {
                                public void execute() {
                                    current.doF() ;
                                }
                        } ;
    private ICommand cmd_g = new ICommand() {
                                public void execute() {
                                    current.doG() ;
                                }
                        } ;
    private ICommand cmd_h = new ICommand() {
                                public void execute() {
                                    current.doH() ;
                                }
                        } ;


    // enter keypad digits
    public void key(String cmd) {
        current.key( cmd ) ;
    }
    
    // instruction message
    public String message() { 
        return current.message1() + "\n" + current.message2() + "\n" ;
    }

    // ad message
    public String advertisement() {
        return  getAd() ;
    }

    // key press labels
    public String A() { return current.A() ; }
    public String B() { return current.B() ; }
    public String C() { return current.C() ; }
    public String D() { return current.D() ; }
    public String E() { return current.E() ; }
    public String F() { return current.F() ; }
    public String G() { return current.G() ; }
    public String H() { return current.H() ; }

    // key press actions
    public void selectA() { cmd_a.execute() ; }
    public void selectB() { cmd_b.execute() ; }
    public void selectC() { cmd_c.execute() ; }
    public void selectD() { cmd_d.execute() ; }
    public void selectE() { cmd_e.execute() ; }
    public void selectF() { cmd_f.execute() ; }
    public void selectG() { cmd_g.execute() ; }
    public void selectH() { cmd_h.execute() ; }

}
