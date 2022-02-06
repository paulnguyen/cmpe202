
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GumballMachineTest
{

    public GumballMachineTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGumballCost25() {

        GumballMachine m = new GumballMachine(25); // 25 cents
        m.refill(2) ; // 2 gumnballs

        assertEquals(2,m.getInventory()) ;
        m.insertCoin(25);
        assertEquals(25,m.getCoinValue()) ;
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.purchase();
        assertEquals("NoCoinsState",m.getState().getClass().getName()) ;
        m.insertCoin(10);
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.purchase();
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.insertCoin(25);
        m.purchase();
        assertEquals("SoldOutState",m.getState().getClass().getName()) ;
        assertEquals(0,m.getInventory()) ;
        assertEquals(0,m.getCoinValue()) ;

    }

    
    @Test
    public void testGumballCost50() {

        GumballMachine m = new GumballMachine(50); // 50 cents
        m.refill(2) ; // 2 gumnballs

        assertEquals(2,m.getInventory()) ;
        m.insertCoin(25);
        assertEquals(25,m.getCoinValue()) ;
        m.insertCoin(25);
        assertEquals(50,m.getCoinValue()) ;
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.purchase();
        assertEquals("NoCoinsState",m.getState().getClass().getName()) ;
        m.insertCoin(10);
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.purchase();
        assertEquals("HasCoinsState",m.getState().getClass().getName()) ;
        m.insertCoin(25);
        m.ejectCoins();
        assertNotEquals("SoldOutState",m.getState().getClass().getName()) ;
        assertEquals(1,m.getInventory()) ;
        assertEquals(0,m.getCoinValue()) ;

    }
    
}
