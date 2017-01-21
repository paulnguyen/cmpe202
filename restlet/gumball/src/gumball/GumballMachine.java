package gumball ;

public class GumballMachine {
 
	private static GumballMachine theMachine ;

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;

	private GumballMachine() { }
 
	public static GumballMachine getInstance() {
		if (theMachine == null) {
			theMachine = new GumballMachine() ;
			theMachine.init( 100 ) ;
			return theMachine ;
		}
		else {
			return theMachine ;
		}
	}
 
	private void init( int numberGumballs ) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}

	public void insertQuarter() {
		state.insertQuarter();
	}
 
	public void ejectQuarter() {
		state.ejectQuarter();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	public int getCount() {
		return count;
	}

	public String getStateString() {
		return this.state.toString() ;
	}	

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
  
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
