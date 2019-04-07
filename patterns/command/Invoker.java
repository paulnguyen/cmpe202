package command;

public interface Invoker {
 
	public abstract void setCommand(Command cmd);
	public abstract void invoke();
}
 
