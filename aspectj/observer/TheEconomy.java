
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

    public static void main ( String args[] )
    {
        TheEconomy E = new TheEconomy() ;
        Optimist O = new Optimist() ;
        Pessimist P = new Pessimist() ;
        E.attach(O) ;
        E.attach(P) ;
        E.setState("The Price of gas is at $5.00/gal");
        O.display();
        P.display();
        E.setState("The New iPad is out today");
        O.display();
        P.display();
    }

}

/*

The Price of gas is at $5.00/gal
The New iPad is out today

*/
