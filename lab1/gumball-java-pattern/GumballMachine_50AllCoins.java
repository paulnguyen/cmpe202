public class GumballMachine_50AllCoins extends GumballMachine {
    GumballMachine_50AllCoins() {
        // call super class constructor to initialize the inventory,accepted coins and gumball cost
        super(4, new int[] { 5,10,25 }, 50);
    }
}