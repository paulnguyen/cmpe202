
public class GumballMachine {
    private State soldOutState;
    private State noCoinsState;
    private State hasCoinsState;
    private State soldState;

    private State state = soldOutState;
    private int count = 0; // inventory
    private int coinValue = 0 ; // cents
    private int cost = 0 ; // configure at setup

    public GumballMachine(int cost) {

        soldOutState = new SoldOutState(this);
        noCoinsState = new NoCoinsState(this);
        hasCoinsState = new HasCoinsState(this);
        soldState = new SoldState(this);

        this.cost = cost;
        state = soldOutState;

    }

    // public interface 

    public void insertCoin(int value) {
        state.insertCoin(value);
    }

    public void ejectCoins() {
        state.ejectCoins();
    }

    public void purchase() {
        state.purchase();
        state.dispense();
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

    public void refill(int count) {
        this.count = count;
        state = noCoinsState;
    }

    // for unit testing
    State getState() {
        return state;
    }

    // for state object use (package scope)

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count>0) {
            System.out.println( "Change Return: " + (coinValue - cost) + " cents." ) ;
        }
        else {
            System.out.println( "Sorry, Sold Out!  Change Return: " + (coinValue - cost) + " cents." ) ;
        }
        if (count != 0) {
            count = count - 1;
        }
        coinValue = 0 ;
    }

    void dumpConfig() {
        System.out.println( "Gumball Inventory: " + count ) ;
        System.out.println( "Gumball Cost:      " + cost ) ;
        System.out.println( "Coin Value:        " + coinValue ) ;
    }

    int getInventory() { return count ; }

    int  getCoinValue() { return coinValue ; }

    void addCoinValue(int v) { coinValue += v ; }

    void returnCoins() {
        System.out.println("=> Return Coins...");
        System.out.println( "Change Return: " + coinValue  + " cents." ) ;
        coinValue = 0 ;
    }

    void setCost( int c ) { cost = c ; }

    int  getCost() { return cost ; }

    void setSoldOutState() {
        this.state = soldOutState ;
    }

    void setNoCoinsState() {
        this.state = noCoinsState ;
    }

    void setHasCoinsState() {
        this.state = hasCoinsState ;
    }

    void setSoldState() {
        this.state = soldState ;
    }

}
