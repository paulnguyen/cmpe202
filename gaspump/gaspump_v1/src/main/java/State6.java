
public class State6 implements State {

	private Screen screen ;

	public State6( Screen screen ) {
		this.screen = screen ;
	}

	public String message1() { return "Print Receipt?" ; }
	public String message2() { return "" ; }
	
	public void key( String keypad ) { screen.setState(-1) ;}

	public String A() { return "" ; 	}
	public String B() { return "" ; 	}
	public String C() { return "Yes" ; 	}
	public String D() { return "No" ; 	}
	public String E() { return "" ; 	}
	public String F() { return "" ; 	}
	public String G() { return "Help" ; }
	public String H() { return "Done" ; }

	public void doA() { }
	public void doB() { }
	public void doC() { screen.setState(-1) ; }
	public void doD() { screen.setState(-1) ; }
	public void doE() { }
	public void doF() { }
	public void doG() { screen.setState(-1) ; }
	public void doH() { screen.setState(-1) ; }

}
 