
public privileged aspect GumballTwoQuarters {


    // PointCut
    after(GumballMachine m): target(m) && call(void GumballMachine.insertQuarter(..)) {
    	int val = m.getCoinValue() ;
    	if ( val > 50 ) {
    		System.out.println( "Gumball only costs two Quarters!" ) ;
    	}
    	return ;
    }
		
	
}
