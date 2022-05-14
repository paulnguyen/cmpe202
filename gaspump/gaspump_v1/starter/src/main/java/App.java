
/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen s;

    public App() {
        s = new Screen();
    }

    public String display() {
        String output = "";
        output += "========================================\n" ;
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += "[A]                                  [F]\n" ;
        output += "\n"                                         ;
        output += "[B]                                  [G]\n" ;
        output += "\n"                                         ;
        output += "[C]                                  [H]\n" ;
        output += "\n"                                         ;
        output += "[D]                                  [I]\n" ;
        output += "\n"                                         ;
        output += "========================================\n" ;
        return output;
    }

    public void key(String keypad) {
        s.key(keypad);
    }

}

