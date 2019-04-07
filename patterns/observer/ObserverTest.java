package observer;

public class ObserverTest
{
    public void runTest()
    {
        observer.TheEconomy s = new observer.TheEconomy();
        observer.Pessimist p = new observer.Pessimist(s);
        observer.Optimist o = new observer.Optimist(s);
        s.attach(p);
        s.attach(o);
        s.setState("The New iPad is out today");
        p.showState();
        o.showState();
        s.setState("Hey, Its Friday!");
        p.showState();
        o.showState();
    }
    
    public static void main( String [] args )
    {
        ObserverTest t = new ObserverTest() ;
        t.runTest() ;
    }     
    
}

