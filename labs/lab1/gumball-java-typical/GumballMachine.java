import java.util.Arrays;
public class GumballMachine {
    // instance variables
    private int num_gumballs;
    private boolean has_amount;
    private int[] acceptedCoins;
    private int gumballCost;
    private int currentAmount;

    public GumballMachine(int size, int acceptCoins[], int gumballcost) {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_amount = false;
        this.acceptedCoins = Arrays.copyOf(acceptCoins, acceptCoins.length);
        this.gumballCost = gumballcost;
        this.currentAmount = 0;
    }
    //Function  to accept coins and validate if 25 or 50 cents amount is inserted
    public void insertCoin(int coins[]) {
        this.currentAmount = 0; // initialize sum

        // reduce time complexity if possible
        for (int i = 0; i < this.acceptedCoins.length; i++) { //check if inserted coins are acceptable - either Nickel/Dime/Quarter as per GumballMachine
            for (int j = 0; j < coins.length; j++) {
                if (acceptedCoins[i] == coins[j]) {
                    this.currentAmount = this.currentAmount + coins[j];
                }
            }
        }
        if (this.currentAmount >= this.gumballCost) //
        {
            this.has_amount = true;
        } else {
            this.has_amount = false;
        }
    }

    public void turnCrank() {
        if (this.has_amount) {
            if (this.num_gumballs > 0) {
                this.num_gumballs--;
                System.out.println("Thanks for the money.Gumball Ejected!");
            } else {
                System.out.println("No More Gumballs! Sorry, can't return your coin.");
            }
            this.has_amount = false; // reset the amount in gumballmachine 
            this.currentAmount = 0;
        } else { //calculate how much more is required and print accordingly
            int needMoney = 0;
            needMoney = (this.gumballCost - this.currentAmount);
            System.out.println("Please insert more " + needMoney + " cents to get one gumball");
        }
    }
}