package state;

public class VmPoweredOn extends VmState {

    public VmPoweredOn( VirtualMachineManager vmm )
    {
        super( vmm ) ;
    }

    @Override
    public void doPowerOff() {
        vm_manager.setState( VmStates.OFF );
    }

    @Override
    public void doSuspend() {
        vm_manager.setState( VmStates.SUSPENDED );
    }

    @Override
    public void doReset() {
        vm_manager.setState( VmStates.ON );
    }

}
 
