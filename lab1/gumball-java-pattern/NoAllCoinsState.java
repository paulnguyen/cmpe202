
/**
 * Accept all coins.
 *
 * @author Chi Tran
 * @version Feb-08-2019
 */
public class NoAllCoinsState implements State
{
   GumballMachine3 gumballMachine3;
   int totalCoins = 0;
 
    public NoAllCoinsState(GumballMachine3 gumballMachine3) {
        this.gumballMachine3 = gumballMachine3;
    }
 
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
    }
 
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }
 
    /**
     * Get coins and count total value of coints to change to the next state
     */
    public void insertCoin(int coin) {
        totalCoins = totalCoins + coin;
        System.out.println("You have inserted " + coin);
        if (totalCoins == 50)
        gumballMachine3.setState(gumballMachine3.getHasAllCoinsState());
        else
        System.out.println("Please insert 50 cents");
        
    }
 
    public void ejectCoin() {
        System.out.println("You haven't inserted enough coins");
    }
    
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
     }
 
    public void dispense() {
        System.out.println("You need to pay first");
    } 
 
    public String toString() {
        return "waiting for quarter";
    }
}
