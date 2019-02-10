/**
 * Class for machine 2 - accepts two quarters
 *
 * @author Chi Tran
 * @version Feb-02-2019
 */
public class GumballMachine2 {
 
    State soldOutState;
    State noDoubleQuarterState;
    State hasDoubleQuarterState;
    State soldState;
 
    State state = soldOutState;
    int count = 0;
 
    /**
     * Constructor for objects of class GumballMachine2
     */
    public GumballMachine2(int numberGumballs) {
        GumballMachine gumballMachine = new GumballMachine(5);
        soldOutState = new SoldOutState(gumballMachine);
        noDoubleQuarterState = new NoDoubleQuarterState(this);
        hasDoubleQuarterState = new HasDoubleQuarterState(this);
        soldState = new SoldState(gumballMachine);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noDoubleQuarterState;
        } 
    }
 
    public void insertQuarter() {
        state.insertQuarter();
    }
 
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void insertCoin(int coin) {
        state.insertCoin(coin);
    }
 
    public void ejectCoin() {
        state.ejectCoin();
    }
 
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
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
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noDoubleQuarterState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoDoubleQuarterState() {
        return noDoubleQuarterState;
    }

    public State getHasDoubleQuarterState() {
        return hasDoubleQuarterState;
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
