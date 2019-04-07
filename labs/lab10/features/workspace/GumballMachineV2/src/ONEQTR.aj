
public privileged aspect ONEQTR {
	
    // PointCut
	void around(GumballMachine m) : target(m) && execution(void GumballMachine.insertQuarter(..))
	{
		int val = m.getCoinValue() ;
		if ( val >= 25 ) {
    		System.out.println( "Machine only accepts one Quarter!" ) ;
    	}
		else {
			proceed(m);
		}
	}
	
	

}

