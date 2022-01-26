
public class Main {

    public static void main(String[] args) {
    	Account acct = new Account(100.00) ;
    	try {
    		acct.debit(50.00) ;
    		acct.credit(500);
    		double bal = acct.getBalance() ;
    		System.out.println( "Got Balance = " + String.valueOf(bal) ) ;
    		acct.showBalance() ;
    		System.out.println(acct) ;
    	} catch (Exception e) {
    		System.out.println(e) ;
    	}
    }	
	
}
