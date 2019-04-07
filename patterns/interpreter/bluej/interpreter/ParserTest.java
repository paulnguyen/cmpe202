
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest
{
    private Parser p ;
    
    public ParserTest()
    {
    }

    @Before
    public void setUp()
    {
        p = new Parser() ;
    }

    @Test
    public void test1()
    {
        String val = p.interpret( "Robot: Decaf[1/2] Shots[D] Milk[NF] Drink[L]" ) ;
        System.out.println( val ) ;
    }

    @Test
    public void test2()
    {
        String val = p.interpret( "Robot: Decaf[NO] Shots[1] Milk[NF] Drink[C]" ) ;
        System.out.println( val ) ;
    }
    
    @Test
    public void test3()
    {
        String val = p.interpret( "Robot: Shots[1] Milk[NF] Drink[M]" ) ;
        System.out.println( val ) ;
    }

    @Test
    public void test4()
    {
        String val = p.interpret( "Robot: Shots[3] Milk[NF] Drink[CM]" ) ;
        System.out.println( val ) ;
    }

    @Test
    public void test5()
    {
        String val = p.interpret( "Robot: Decaf[1/2] Shots[2] Milk[2] Drink[L]" ) ;
        System.out.println( val ) ;
    }
    
    
    @After
    public void tearDown()
    {
    }
}
