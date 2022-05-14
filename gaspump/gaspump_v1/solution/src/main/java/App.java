
/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private IScreen s;

    public App() {
        s = new Decorator( new Screen() ) ;
    }

    public String display() {
        String output = "";
        output += "========================================\n"     ;
        output += "\n"                                             ;
        output += s.message()                                      ;
        output += "\n"                                             ;
        output += "[A] " + s.A() + "          " + s.E() + " [E]\n" ;
        output += "\n"                                             ;
        output += "[B] " + s.B() + "          " + s.F() + " [F]\n" ;
        output += "\n"                                             ;
        output += "[C] " + s.C() + "          " + s.G() + " [G]\n" ;
        output += "\n"                                             ;
        output += "[D] " + s.D() + "          " + s.H() + " [H]\n" ;
        output += "\n"                                             ;
        output += "\n"                                             ;
        output += s.advertisement()                                ;
        output += "\n"                                             ;        
        output += "========================================\n"     ;
        return output;
    }

    public void key(String cmd) {
        switch ( cmd ) {
            case "a":
            case "A":
                s.selectA() ;
                break ;
            case "b":
            case "B":
                s.selectB() ;
                break ;
            case "c":
            case "C":
                s.selectC() ;
                break ;
            case "d":
            case "D":
                s.selectD() ;
                break ;
            case "e":
            case "E":
                s.selectE() ;
                break ;
            case "f":
            case "F":
                s.selectF() ;
                break ;
            case "g":
            case "G":
                s.selectG() ;
                break ;
            case "h":
            case "H":
                s.selectH() ;
                break ;
            default:
                s.key(cmd) ;
        }
        
    }

}

