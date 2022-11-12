
public class StateCarWashPackage implements State {

	private Screen screen ;

	public StateCarWashPackage( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Select Car Wash Package" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { }

	public String A() { return "Basic" ; }
	public String B() { return "Full" ; }
	public String C() { return "Deluxe" ; }
	public String D() { return "" ; }
	public String E() { return "" ; }
	public String F() { return "" ; }
	public String G() { return "" ; }
	public String H() { return "" ; }

	public void doA() { screen.setState(0) ; }
	public void doB() { screen.setState(0) ; }
	public void doC() { screen.setState(0) ; }
	public void doD() { }
	public void doE() { }
	public void doF() { }
	public void doG() { }
	public void doH() { }	

}
 