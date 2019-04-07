

import java.lang.reflect.* ;

public class Main1 {


	public static void main( String args[] ) {

        GumballMachine gm = new GumballMachine(10) ;
        GumballProxy handler = new GumballProxy(gm) ;

        IGumballMachine proxy = (IGumballMachine) Proxy.newProxyInstance(
        		IGumballMachine.class.getClassLoader(),
                new Class[] { IGumballMachine.class },
                handler);

        proxy.dumpConfig() ;
        proxy.insertCoinValue(25) ;
        proxy.insertCoinValue(25) ;

	}


}