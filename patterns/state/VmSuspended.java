package state;

public class VmSuspended extends VmState {

    public VmSuspended( VirtualMachineManager vmm )
    {
        super( vmm ) ;
    }

    @Override
    public void doPowerOn() {
        vm_manager.setState( VmStates.ON );
    }
 
}
 
