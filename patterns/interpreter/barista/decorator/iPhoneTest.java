

package decorator ;


public class iPhoneTest
{

    public static void main(final String[] args) {
  
        test1() ;

    }


    public static void test1()
    {

        iPhone iPhone6 =  new iPhone();
        iPhone6.setDecaf("1/2");
        iPhone6.setShots("D");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        System.out.println( iPhone6.sendCommand() );
    }

    public static void test2()
    {
        iPhone iPhone6 =  new iPhone();
        iPhone6.setShots("D");
        iPhone6.setDecaf("1/2");
        iPhone6.setDrink("L");
        iPhone6.setMilk("NF");
        System.out.println( iPhone6.sendCommand() );    
    }

    public static void test3()
    {
        iPhone iPhone6 =  new iPhone();
        iPhone6.setDecaf("NO");
        iPhone6.setShots("1");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        System.out.println( iPhone6.sendCommand() );    
    }

    public static void test4()
    {
        iPhone iPhone6 =  new iPhone();
        iPhone6.setDrink("L");
        iPhone6.setShots("1");
        iPhone6.setMilk("NF");
        System.out.println( iPhone6.sendCommand() );
    }

    public static void test5()
    {
        iPhone iPhone6 =  new iPhone();
        iPhone6.setShots("3");
        iPhone6.setMilk("NF");
        iPhone6.setDrink("L");
        System.out.println( iPhone6.sendCommand() );
    }
    


}

