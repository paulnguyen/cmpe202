public class Main {
      public static void main(String[] args) {
      
        int insertCoins[];
       // int inventory = 2;

       //Gumball Machine 1 
        GumballMachine GumballMachine_25_Obj = new GumballMachine_25Quart();
        System.out.println("######## Success test case GumballMachine1 "+GumballMachine_25_Obj+" ####################");  
        insertCoins = new int[] {25};
        GumballMachine_25_Obj.insertCoin(insertCoins);
        GumballMachine_25_Obj.turnCrank();
       
        GumballMachine_25_Obj.insertCoin(insertCoins);
        GumballMachine_25_Obj.turnCrank();
        
        //test case for no inventory 
        System.out.println("###### Test case for no inventory GumballMachine1 "+GumballMachine_25_Obj+" #############");  
        GumballMachine_25_Obj.insertCoin(insertCoins);    
        GumballMachine_25_Obj.turnCrank();

        //GumballMachine2 
        GumballMachine GumballMachine_50Quart_Obj = new GumballMachine_50Quart();
        System.out.println("####### Success test case GumballMachine2 "+GumballMachine_50Quart_Obj+" ####################"); 
        insertCoins = new int[] {25,25};            
        GumballMachine_50Quart_Obj.insertCoin(insertCoins);
        GumballMachine_50Quart_Obj.turnCrank();
        
        GumballMachine_50Quart_Obj.insertCoin(insertCoins);
        GumballMachine_50Quart_Obj.turnCrank();
        
        // test case for not acceptable coins
        System.out.println("####### Test case for not acceptable coins GumballMachine2 "+GumballMachine_50Quart_Obj+" ##########"); 
        insertCoins = new int[] {10,10,5,25};                 
        GumballMachine_50Quart_Obj.insertCoin(insertCoins);
        GumballMachine_50Quart_Obj.turnCrank();
        
        insertCoins = new int[] {25};                         // test case for insufficient money inserted
        GumballMachine_50Quart_Obj.insertCoin(insertCoins);
        GumballMachine_50Quart_Obj.turnCrank();
        
        //GumballMachine
        GumballMachine GumballMachine_50AllCoins_Obj = new GumballMachine_50AllCoins();
        System.out.println("####### Success test case GumballMachine3 "+GumballMachine_50AllCoins_Obj+" ##############"); 
        insertCoins = new int[] {10,10,25,5};            // Success test case gumballmachine3 
        GumballMachine_50AllCoins_Obj.insertCoin(insertCoins);
        GumballMachine_50AllCoins_Obj.turnCrank();
        
        System.out.println("####### Success test case GumballMachine3 different coin combination "+GumballMachine_50AllCoins_Obj+" ##"); 
        insertCoins = new int[] {10,10,10,10,10};       // Success test case gumballmachine3 with different combination
        GumballMachine_50AllCoins_Obj.insertCoin(insertCoins);
        GumballMachine_50AllCoins_Obj.turnCrank();
        
        System.out.println("####### Success test case GumballMachine3 different coin combination "+GumballMachine_50AllCoins_Obj+" ##"); 
        insertCoins = new int[] {5,5,10,5,25};       
        GumballMachine_50AllCoins_Obj.insertCoin(insertCoins);     
        GumballMachine_50AllCoins_Obj.turnCrank();
    }
}