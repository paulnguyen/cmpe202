public class NoMoneyState implements State {
    GumballMachine gumballMachine;
 
    public NoMoneyState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int insertedCoins[]) {
        
         this.gumballMachine.currentAmount= 0;     // initialize sum
         int j= 0;
         int i=0;
         
         for ( i = 0; i < this.gumballMachine.acceptedCoins.length; i++)
          {   //check if inserted coins are acceptable - either Nickel/Dime/Quarter as per GumballMachine
              for( j = 0; j < insertedCoins.length; j++)
              {
               if(this.gumballMachine.acceptedCoins[i] == insertedCoins[j])
               {
                this.gumballMachine.currentAmount =  this.gumballMachine.currentAmount + insertedCoins[j];
               }
              }
            }
            
         if ( this.gumballMachine.currentAmount == this.gumballMachine.gumballCost )
             { this.gumballMachine.has_amount = true ; 
               System.out.println("You inserted the required money");
               gumballMachine.setState(gumballMachine.getHasMoneyState());
             }
            else 
           { 
             this.gumballMachine.has_amount = false;
             if(this.gumballMachine.acceptedCoins.length == 1){System.out.println("Insert only quarters") ;}  
             else {System.out.println("Insert only dime,nickel or quarters");}
           }   
    }
 
    public void ejectCoin() {
        System.out.println("You haven't inserted a acceptable coins");
    }
 
    public void turnCrank() {
        System.out.println("You turned, but money is not inserted");
     }
 
    public void dispense() {
        System.out.println("You need to pay first");
    } 
 
    public String toString() {
        return "waiting for coin";
    }
}
