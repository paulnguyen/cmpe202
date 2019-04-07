

package interpreter ;

public class ParserTest
{

    public static void main(final String[] args) {
  
        test1() ;

    }

    public static void test1()
    {
        Parser p = new Parser() ;
        String val = p.interpret( "Robot: Decaf[1/2] Shots[D] Milk[NF] Drink[L]" ) ;
        System.out.println( val ) ;
    }

    public static void test2()
    {
        Parser p = new Parser() ;
        String val = p.interpret( "Robot: Decaf[NO] Shots[1] Milk[NF] Drink[C]" ) ;
        System.out.println( val ) ;
    }
    
    public static void test3()
    {
        Parser p = new Parser() ;
        String val = p.interpret( "Robot: Shots[1] Milk[NF] Drink[M]" ) ;
        System.out.println( val ) ;
    }

    public static void test4()
    {
        Parser p = new Parser() ;
        String val = p.interpret( "Robot: Shots[3] Milk[NF] Drink[CM]" ) ;
        System.out.println( val ) ;
    }

    public static void test5()
    {
        Parser p = new Parser() ;
        String val = p.interpret( "Robot: Decaf[1/2] Shots[2] Milk[2] Drink[L]" ) ;
        System.out.println( val ) ;
    }
    
}
