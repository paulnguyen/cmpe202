package state;

public class VmPoweredOff extends VmState {

    public VmPoweredOff( VirtualMachineManager vmm )
    {
        super( vmm ) ;
    }

    @Override
    public void doPowerOn() {
        vm_manager.setState( VmStates.ON );
    }
 
}
 
