package command;

public interface Command {
 
	public abstract void execute();
	public abstract void setReceiver(Receiver target);
}
 
