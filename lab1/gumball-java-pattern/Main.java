
public class Main {
    public static void main(String[] args) {
        
        int acceptCoins[];
        int insertCoins[];
        int inventory = 2;
        int GumballCost = 25;
        
        // GumballMAchine1 cases
        acceptCoins = new int[] {25};
        GumballMachine gumballMachine1 = new GumballMachine(inventory,acceptCoins,GumballCost);
        
        System.out.println("############# Test Case sucessful gumball ejection "+gumballMachine1+" ############################");
        insertCoins = new int[] {25};
        System.out.println(gumballMachine1);
        gumballMachine1.insertCoin(insertCoins);
        gumballMachine1.turnCrank();
        
        System.out.println("################### Test Case no money "+gumballMachine1+" ############################");
        gumballMachine1.turnCrank();      // test case for no money state
        
        System.out.println("################### Test Case out of stock "+gumballMachine1+" ############################");
        gumballMachine1.insertCoin(insertCoins);
        gumballMachine1.turnCrank();
        gumballMachine1.insertCoin(insertCoins);
        gumballMachine1.turnCrank();   
        
        // GumballMAchine2 cases
       
        GumballCost = 50;
        inventory = 3;
        insertCoins = new int[] {25,25}; 
        GumballMachine gumballMachine2 = new GumballMachine(inventory,acceptCoins,GumballCost);
        System.out.println("################### Test Case sucessful gumball ejection "+gumballMachine2+" ############################");
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        System.out.println("################### Test Case for unacceptable coins "+gumballMachine2+" ############################");
        insertCoins = new int[] {5,10,25};                        
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        System.out.println("################### Test Case for insuffucient money "+gumballMachine2+" ############################");
        insertCoins = new int[] {25};                        
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        // GumballMAchine3 cases
        acceptCoins = new int[] {5,10,25};
        GumballMachine gumballMachine3 = new GumballMachine(inventory,acceptCoins,GumballCost);
        System.out.println("################### Test Case for different combination "+gumballMachine3+" ############################");
        insertCoins = new int[] {5,5,10,10,10,10}; 
        gumballMachine3.insertCoin(insertCoins);
        gumballMachine3.turnCrank();


    }
}
