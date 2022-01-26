
class GumballMachineTest {

	public static void main( String args[ ] )
	{	
		// Adapt Basic Gumball Machine
		IGumballMachineCrank m1 = new IGumballMachineCrank() {
			GumballMachine m ;			
			{  	m = new GumballMachine(10) ; 
				m.setCost(25) ; 
			} 
			public void insertQuarter() {
				int val = m.getCoinValue() ;
				int cost = m.getCost() ;
		        if ( val >= cost ) {
		            System.out.println( "Gumball only costs one Quarter!" ) ;
		        } else {
		            m.insertCoinValue( 25 ) ;  
		        }
			}
			public void turnTheCrank() {
        		System.out.println("=> Turn The Crank...") ;
        		m.ejectGumball() ;  
			}
		} ;

		IGumballMachineCrank m2 = new IGumballMachineCrank() {
			GumballMachine m ;			
			{  	m = new GumballMachine(10) ; 
				m.setCost(50) ; 
			} 
			public void insertQuarter() {
				int val = m.getCoinValue() ;
				int cost = m.getCost() ;
		        if ( val >= cost ) {
		            System.out.println( "Gumball only costs two Quarters!" ) ;
		        } else {
		            m.insertCoinValue( 25 ) ;  
		        }
			}
			public void turnTheCrank() {
        		System.out.println("=> Turn The Crank...") ;
        		m.ejectGumball() ;  
			}
		} ;		

		IGumballMachineSlot m3 = new IGumballMachineSlot() {
			GumballMachine m ;			
			{  	m = new GumballMachine(10) ; 
				m.setCost(50) ; 
			} 
		    public void insertCoin(int value) {
		        System.out.println("=> Insert Coin: " + value + " cents") ;
		        m.insertCoinValue(value) ;
		        int coinValue = m.getCoinValue() ;
		        int cost = m.getCost() ;
		        if (coinValue >= cost)
		            m.ejectGumball() ;
		    }
		    public void returnCoins() {
		        System.out.println("=> Return Coins...");
		        int coinValue = m.getCoinValue() ;
		        System.out.println( "Change Return: " + coinValue  + " cents." ) ;
		        m.setCoinValue( 0 ) ;
		    }
		} ;	

		// Happy Path Tests
		System.out.println("\n") ;
		System.out.println("===== Gumball Machine #1 =====") ;
		m1.insertQuarter() ;
        m1.insertQuarter() ;
        m1.turnTheCrank() ;
        System.out.println("\n") ;
        System.out.println("===== Gumball Machine #2 =====") ;
        m2.insertQuarter() ;
        m2.insertQuarter() ;
        m2.insertQuarter() ;
        m2.turnTheCrank() ;
        System.out.println("\n") ;
        System.out.println("===== Gumball Machine #3 =====") ;
        m3.insertCoin(10) ;
        m3.insertCoin(25) ;
        m3.insertCoin(50) ;
        m3.insertCoin(10) ;
        m3.returnCoins() ;

	}	

}