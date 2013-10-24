package state;

public class VmState implements VirtualMachineState {
 
	VirtualMachineManager vm_manager;
	 
	public VmState(VirtualMachineManager vmm) {
        vm_manager = vmm ;
	}

	public void doPowerOn() {
        System.out.println( "Power On is not valid in " + this.getClass().getName() + " state." );
	}

	public void doPowerOff() {
        System.out.println( "Power Off is not valid in " + this.getClass().getName() + " state." );
	}

	public void doSuspend() {
        System.out.println( "Suspend is not valid in " + this.getClass().getName() + " state." );
	}

	public void doReset() {
        System.out.println( "Reset is not valid in " + this.getClass().getName() + " state." );
	}
	 
}
 
