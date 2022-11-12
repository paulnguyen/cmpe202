
import java.util.* ;

public class Decorator implements IScreen
{
    IScreen s ;

    public Decorator( IScreen screen)
    {
        this.s = screen ;
    }

    public void key(String cmd) {
        s.key( cmd ) ;
    }
    
    public String message() { 
        String[] lines = s.message().split("\n"); 
        String new_message = "" ;
        System.err.println( "# lines: " + lines.length ) ;
        for ( int i = 0; i<lines.length; i++ ) {
            System.err.println( "line # " + i +1 ) ;
            int len = lines[i].length() ;
            System.err.println( "line len: " + len ) ;
            int pad = (int) Math.ceil((double)(40-len)/(double)2);
            System.err.println( "pad size: " + pad ) ;
            String new_line = "" ;
            for ( int k = 0; k<pad; k++ ) {
                new_line += " "  ;
            }
            new_line += lines[i] ;
            System.err.println( "new line: " + new_line ) ;
            new_message += new_line + "\n" ;
            System.err.println( "new message: " + new_message ) ;
        }
        if ( lines.length < 2 )
            new_message += "\n" ;
        return new_message ; 
    }

    public String advertisement() {
        String ad = s.advertisement() ;
        int len = ad.length() ;
        int pad = (int) Math.ceil((double)(40-len)/(double)2);
        String pad_spaces = "" ;
        for ( int k = 0; k<pad; k++ ) {
            pad_spaces += " "  ;
        }        
        return pad_spaces + ad + "\n" ;
    }

    public String A() { return padr(s.A()) ; }
    public String B() { return padr(s.B()) ; }
    public String C() { return padr(s.C()) ; }
    public String D() { return padr(s.D()) ; }
    public String E() { return padl(s.E()) ; }
    public String F() { return padl(s.F()) ; }
    public String G() { return padl(s.G()) ; }
    public String H() { return padl(s.H()) ; }

    public void selectA() { s.selectA() ; }
    public void selectB() { s.selectB() ; }
    public void selectC() { s.selectC() ; }
    public void selectD() { s.selectD() ; }
    public void selectE() { s.selectE() ; }
    public void selectF() { s.selectF() ; }
    public void selectG() { s.selectG() ; }
    public void selectH() { s.selectH() ; }

    private String padr( String s ) {
        String new_s = s ;
        int len = s.length() ;
        int pad = 11 - len ;
        for ( int i = 0; i<pad; i++ ) {
            new_s += " " ;
        }
        return new_s ;
    }

    private String padl( String s ) {
        String new_s = s ;
        int len = s.length() ;
        int pad = 11 - len ;
        for ( int i = 0; i<pad; i++ ) {
            new_s = " " + new_s ;
        }
        return new_s ;        
    }

}



/*

========================================

            Credit or Debit?


[A]                                  [E]

[B]                                  [F]

[C] Credit                           [G]

[D] Debit                            [H]

========================================

=> 

----------------------------------------
              |          |
1234567890123456789012345678901234567890
----------------------------------------
[C] Credit                           [H]
[D] Debit                            [I]

*/