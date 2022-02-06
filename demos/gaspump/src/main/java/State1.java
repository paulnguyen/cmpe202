
public class State1 implements State {

	private Screen screen ;

	public State1( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Scan Credit Card" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { 
		System.err.println( "Credit Card: " + keypad ) ;
		screen.setState(3) ;
	}

	public String A() { return "" ; }
	public String B() { return "" ; }
	public String C() { return "" ; }
	public String D() { return "" ; }
	public String E() { return "" ; }
	public String F() { return "" ; }
	public String G() { return "" ; }
	public String H() { return "" ; }

	public void doA() { }
	public void doB() { }
	public void doC() { }
	public void doD() { }
	public void doE() { }
	public void doF() { }
	public void doG() { }
	public void doH() { }	

}
 