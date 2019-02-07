import java.util.Arrays;

public abstract class GumballMachine {

    // instance variables
    private int num_gumballs, gumballCost,currentAmount;
    private boolean has_amount;
    private int[] acceptedCoins;

    //Constructor
    public GumballMachine(int size, int acceptCoins[], int gumballCost) {
        // initialise instance variables
        this.num_gumballs = size;
        this.has_amount = false;
        this.acceptedCoins = acceptCoins;
        this.gumballCost = gumballCost;
        this.currentAmount = 0;
        System.out.println("GumballMachine Invnentory " + this.num_gumballs + "costs " +this.gumballCost+ " for one gumball accepts");
        for (int i = 0; i < this.acceptedCoins.length; i++) 
        {  System.out.println( + this.acceptedCoins[i]);}
        
    }

    public void insertCoin(int coins[]) {
        this.currentAmount = 0; // initialize sum

        for (int i = 0; i < this.acceptedCoins.length; i++) { //check if inserted coins are acceptable - either Nickel/Dime/Quarter as per GumballMachine
            for (int j = 0; j < coins.length; j++) {
                if (this.acceptedCoins[i] == coins[j]) {
                    this.currentAmount = this.currentAmount + coins[j];
                }
            }
        }
        if (this.currentAmount >= this.gumballCost) {
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
            System.out.println("You inserted " + needMoney + " cents less to get one gumball");
        }

    }
}

class GumballMachine_25Quart extends GumballMachine {
    GumballMachine_25Quart() {
        super(2, new int[] { 25 }, 25);
    }
}

class GumballMachine_50Quart extends GumballMachine {
    GumballMachine_50Quart() {
        super(5, new int[] { 25 }, 50);
    }
}

class GumballMachine_50AllCoins extends GumballMachine {
    GumballMachine_50AllCoins() {
        super(5, new int[] { 5,10,25 }, 50);
    }
}