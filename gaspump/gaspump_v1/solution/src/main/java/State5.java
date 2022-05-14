
public class State5 implements State {

	private Screen screen ;

	public State5( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Select Grade & Pump Gas..." ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { screen.setState(6) ; }

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
 