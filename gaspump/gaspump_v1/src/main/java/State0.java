
public class State0 implements State {

	private Screen screen ;

	public State0( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Credit or Debit?" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { }

	public String A() { return "" ; }
	public String B() { return "" ; }
	public String C() { return "Credit" ; }
	public String D() { return "Debit" ; }
	public String E() { return "" ; }
	public String F() { return "" ; }
	public String G() { return "" ; }
	public String H() { return "" ; }

	public void doA() { }
	public void doB() { }
	public void doC() { screen.setState(1) ; }
	public void doD() { screen.setState(2) ; }
	public void doE() { }
	public void doF() { }
	public void doG() { }
	public void doH() { }	

}
 