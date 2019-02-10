

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter( 25 );
		gumballMachine.turnCrankForQuarter();
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter( 25 );
		gumballMachine.insertQuarter( 25 );
		gumballMachine.turnCrankFor2Quarters();
		System.out.println(gumballMachine);
		
		gumballMachine.insertDime( 10 );
		gumballMachine.insertDime( 10 );
		gumballMachine.insertQuarter( 25 );
		gumballMachine.insertOneCent(1);
		gumballMachine.insertOneCent(1);
		gumballMachine.insertOneCent(1);
		gumballMachine.insertOneCent(1);
		gumballMachine.insertOneCent(1);
		gumballMachine.turnCrankForAllCoints();
		System.out.println(gumballMachine);
	}
}
