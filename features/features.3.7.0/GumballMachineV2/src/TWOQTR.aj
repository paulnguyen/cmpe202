
public privileged aspect TWOQTR {

    // PointCut
	void around(GumballMachine m) : target(m) && execution(void GumballMachine.insertQuarter(..))
	{
		int val = m.getCoinValue() ;
		if ( val >= 50 ) {
			System.out.println( "Machine accepts two Quarters!" ) ;
    	}
		else {
			proceed(m);
		}
	}
	    
			
	
}