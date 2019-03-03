

public class Main {

    public static void main(String[] args) {
        
        //Initialize three machines    
        GumballMachine gumballMachine = new GumballMachine(5);
        GumballMachine2 gumballMachine2 = new GumballMachine2(6);
        GumballMachine3 gumballMachine3 = new GumballMachine3(7);

        System.out.println(gumballMachine);
        System.out.println(gumballMachine2);
        System.out.println(gumballMachine3);
        
        //Insert quater and get gumble from the first machine
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        
        //Insert two quaters and get gumble from the second machine
        gumballMachine2.insertQuarter();
        gumballMachine2.insertQuarter();
        gumballMachine2.turnCrank();
        System.out.println(gumballMachine2);
        
        //Insert coins and get gumble from the third machine
        gumballMachine3.insertCoin(25);
        gumballMachine3.insertCoin(10);
        gumballMachine3.insertCoin(10);
        gumballMachine3.insertCoin(1);
        gumballMachine3.insertCoin(1);
        gumballMachine3.insertCoin(1);
        gumballMachine3.insertCoin(1);
        gumballMachine3.insertCoin(1);
        gumballMachine3.turnCrank();
        System.out.println(gumballMachine3);
        
    }
}
