
int x = 30;

void setup() 
{
  size(500, 500);
  background(102);
  // Only draw once
  noLoop();
}

void draw() {
  fill(255);
  text("The Gumball Machine", 30, 60);
  runTest() ;
}


public void runTest() {
  GumballMachine gumballMachine = new GumballMachine(5);

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

