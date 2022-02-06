

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(25); // 25 cents
		gumballMachine.refill(100) ; // 100 gumnballs

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.purchase();

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.purchase();
		gumballMachine.insertCoin(25);
		gumballMachine.purchase();

		System.out.println(gumballMachine);
	}
}
