
public class State0 implements State {

	private Screen screen ;

	public State0( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Credit or Debit?" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { }

	public String A() { return "Credit" ; }
	public String B() { return "Debit" ; }
	public String C() { return "" ; }
	public String D() { return "" ; }
	public String E() { return "" ; }
	public String F() { return "" ; }
	public String G() { return "" ; }
	public String H() { return "" ; }

	public void doA() { screen.setState(1) ; }
	public void doB() { screen.setState(2) ; }
	public void doC() { }
	public void doD() { }
	public void doE() { }
	public void doF() { }
	public void doG() { }
	public void doH() { }	

}
 