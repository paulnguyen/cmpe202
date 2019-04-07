
public privileged aspect GumballOneQuarter {

    // PointCut
    after(GumballMachine m): target(m) && call(void GumballMachine.insertQuarter(..)) {
    	int val = m.getCoinValue() ;
    	if ( val > 25 ) {
    		System.out.println( "Gumball only costs one Quarter!" ) ;
    	}
    	return ;
    }
	
	
}

