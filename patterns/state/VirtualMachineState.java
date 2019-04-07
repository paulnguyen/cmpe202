package state;

public interface VirtualMachineState {
	 
	public abstract void doPowerOn();
	public abstract void doPowerOff();
	public abstract void doSuspend();
	public abstract void doReset();
}
 
