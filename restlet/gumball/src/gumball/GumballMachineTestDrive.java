package gumball ;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = GumballMachine.getInstance() ;

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
