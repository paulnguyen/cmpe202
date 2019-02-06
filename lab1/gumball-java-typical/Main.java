public class Main {
      public static void main(String[] args) {
          
        int acceptCoins[];
        int insertCoins[];
        int inventory = 2;
        int GumballCost = 25;
        
       //Gumball Machine 1 
        acceptCoins = new int[] {25};               // set accepted denominations(quarter)  
        //instance creation with inventory size, accepted denominations(nickel/quar/dime) and 1 gumball cost in cents
        GumballMachine gumballMachine1 = new GumballMachine(inventory,acceptCoins,GumballCost);
        System.out.println("#################### GumballMachine1 "+gumballMachine1+" ####################");  
        insertCoins = new int[] {25};               //Success test case gumballmachine1
        gumballMachine1.insertCoin(insertCoins);
        gumballMachine1.turnCrank();
        
        gumballMachine1.insertCoin(insertCoins);
        gumballMachine1.turnCrank();
        
        gumballMachine1.insertCoin(insertCoins);    //test case for no inventory gumballmachine1
        gumballMachine1.turnCrank();

        //GumballMachine2 
        GumballCost = 50;
        inventory =4;
        GumballMachine gumballMachine2 = new GumballMachine(inventory,acceptCoins,GumballCost);
        System.out.println("#################### GumballMachine2 "+gumballMachine2+" ####################"); 
        insertCoins = new int[] {25,25};            //Success test case gumballmachine2
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        insertCoins = new int[] {10,10,5,25};        // test case for not acceptable coins
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        
        insertCoins = new int[] {25};               // test case for insufficient money inserted
        gumballMachine2.insertCoin(insertCoins);
        gumballMachine2.turnCrank();
        

        //GumballMachine3
        inventory =3;
        
        acceptCoins =new int[] {25,10,5};
        GumballMachine gumballMachine3 = new GumballMachine(inventory,acceptCoins,GumballCost);
        System.out.println("#################### GumballMachine3 "+gumballMachine3+" ####################"); 
        insertCoins = new int[] {10,10,25,5};            // Success test case gumballmachine3 
        gumballMachine3.insertCoin(insertCoins);
        gumballMachine3.turnCrank();
        
        insertCoins = new int[] {10,10,10,10,10};       // Success test case gumballmachine3 with different combination
        gumballMachine3.insertCoin(insertCoins);
        gumballMachine3.turnCrank();
        
        insertCoins = new int[] {5,5,10,5,25};        // Success test case gumballmachine3 with different combination
        gumballMachine3.insertCoin(insertCoins);     
        gumballMachine3.turnCrank();
    }
}