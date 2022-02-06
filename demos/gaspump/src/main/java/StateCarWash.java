
public class StateCarWash implements State {

	private Screen screen ;

	public StateCarWash( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Do you want a Car Wash?" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { }

	public String A() { return "Yes" ; }
	public String B() { return "No" ; }
	public String C() { return "" ; }
	public String D() { return "" ; }
	public String E() { return "" ; }
	public String F() { return "" ; }
	public String G() { return "" ; }
	public String H() { return "" ; }

	public void doA() { screen.setState(-2) ; }
	public void doB() { screen.setState(0) ; }
	public void doC() { }
	public void doD() { }
	public void doE() { }
	public void doF() { }
	public void doG() { }
	public void doH() { }	

}
 