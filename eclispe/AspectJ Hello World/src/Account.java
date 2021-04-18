
import java.lang.Math;

public class Account {

	int account_number;
	double balance;

	public Account(double deposit) {
		balance = deposit;
		int min = 1239871;
		int max = 9999999;
		account_number = (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public void debit(double amount) throws Exception {
		System.out.println("Debit: " + String.valueOf(amount));
		if (balance < amount) {
			throw new Exception("Total balance not sufficient!");
		} else {
			balance = balance - amount;
		}
	}

	public void credit(double amount) {
		System.out.println("Credit: " + String.valueOf(amount));
		balance = balance + amount;
	}

	@Marker
	public double getBalance() {
		return balance ;
	}
	
	@Marker
	public void showBalance() {
		System.out.println( "The Balance Is: " + String.valueOf(balance) ) ;
	}
	
	public String toString() {
		return "Account: " + String.valueOf(this.account_number) + "  Balance: " + String.valueOf(balance) ;
	}

}
