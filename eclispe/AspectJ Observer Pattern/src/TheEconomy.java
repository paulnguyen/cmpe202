
public class TheEconomy {

    private String TheEconomyState;

    public String getState() {
        return TheEconomyState ;
    }

    public void setState(String status) {
        TheEconomyState = status ;
        showState();
    }

    public void showState()
    {
        System.out.println(this.getClass().getName() + " = " + TheEconomyState);
    }

}

/*

The Price of gas is at $5.00/gal
The New iPad is out today

*/
