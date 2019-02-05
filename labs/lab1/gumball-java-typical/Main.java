
public class Main {
	public static void main(String[] args) {
	    int acceptCoins[] =new int[] {25};
	    int insertCoins[] ;
		// GumballMachine gumballMachine1 = new GumballMachine(5,acceptCoins,25);
		// System.out.println(gumballMachine1);
		// gumballMachine1.insertCoin(acceptCoins);
		// gumballMachine1.turnCrank();
		// System.out.println(gumballMachine1);
		
		GumballMachine gumballMachine2 = new GumballMachine(3,acceptCoins,50);
		insertCoins = new int[] {25,10,10,5}; 
		gumballMachine2.insertCoin(insertCoins);
		gumballMachine2.turnCrank();
		gumballMachine2.insertCoin(insertCoins);
		gumballMachine2.turnCrank();
		gumballMachine2.insertCoin(insertCoins);
		gumballMachine2.turnCrank();
		System.out.println(gumballMachine2);
		
		// acceptCoins =new int[] {5,10,25};
	        // GumballMachine gumballMachine3 = new GumballMachine(1,acceptCoins,50);
	        
		// insertCoins = new int[] {10,10,25,5};
		// gumballMachine3.insertCoin(insertCoins);
		// gumballMachine3.turnCrank();
		// gumballMachine3.insertCoin(insertCoins);
		// gumballMachine3.turnCrank();
		
		// insertCoins = new int[] {10,10,25};
		// gumballMachine3.insertCoin(insertCoins);		
		// gumballMachine3.turnCrank();
		// System.out.println(gumballMachine3);
		

		// insertCoins = new int[] {10};
		// gumballMachine2.insertCoin(insertCoins);
		// gumballMachine2.turnCrank();
		
		// insertCoins = new int[] {40,10};
		// gumballMachine2.insertCoin(insertCoins);
		// gumballMachine2.turnCrank();
		

	}
}
