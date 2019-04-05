

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class iPhoneTest
{
    private iPhone iPhoneTest;
    private iPhone iPhone6;

    public iPhoneTest()
    {
    }

    @Before
    public void setUp()
    {
        iPhone6 = new iPhone();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void test1()
    {
        iPhone6.setDecaf("1/2");
        iPhone6.setShots("D");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        assertEquals("Robot: Decaf[1/2] Shots[D] Milk[NF] Drink[L]", iPhone6.sendCommand());
    }


    @Test
    public void test2()
    {
        iPhone6.setShots("D");
        iPhone6.setDecaf("1/2");
        iPhone6.setDrink("L");
        iPhone6.setMilk("NF");
        assertEquals("Robot: Decaf[1/2] Shots[D] Milk[NF] Drink[L]", iPhone6.sendCommand());
    }

    @Test
    public void test3()
    {
        iPhone6.setDecaf("NO");
        iPhone6.setShots("1");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        assertEquals("Robot: Decaf[NO] Shots[1] Milk[NF] Drink[L]", iPhone6.sendCommand());
    }

    @Test
    public void test4()
    {
        iPhone6.setDrink("L");
        iPhone6.setShots("1");
        iPhone6.setMilk("NF");
        assertEquals("Robot: Shots[1] Milk[NF] Drink[L]", iPhone6.sendCommand());
    }

    @Test
    public void test5()
    {
        iPhone6.setShots("3");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        assertEquals("Robot: Shots[3] Milk[NF] Drink[L]", iPhone6.sendCommand());
    }
    


}

