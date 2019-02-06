
import java.util.Random;

public class HasMoneyState implements State {
    GumballMachine gumballMachine;
 
    public HasMoneyState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
  
    public void insertCoin(int insertedCoins[]) {
        System.out.println("You can't insert another coin");
    }
 
    public void ejectCoin() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoMoneyState());
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
}
