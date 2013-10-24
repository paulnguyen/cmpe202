package command;

public class ConcreteCommand implements Command {
    
    private Receiver theReceiver ;

	public void execute() {
	    theReceiver.doAction();
	}

	public void setReceiver(Receiver target) {
	    theReceiver = target ;
	}
	 
}
 
