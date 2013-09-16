
public class TheEconomy extends ConcreteSubject {

    public TheEconomy()
    {
        attach( new Optimist(this));
        attach( new Pessimist(this));
    }

    public static void main ( String args[] )
    {
        TheEconomy E = new TheEconomy() ;
        E.setState("The Price of gas is at $5.00/gal");
        E.setState("The New iPad is out today");
    }
	 
}

/*

The Price of gas is at $5.00/gal
The New iPad is out today

*/
