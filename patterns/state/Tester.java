package state;

public class Tester {

    public static void main( String[] args )
    {
        VirtualMachineManager vm = new VirtualMachineManager() ;
        vm.showState() ;
        vm.powerOn() ;
        vm.showState() ;
        vm.suspend() ;
        vm.showState() ;
        vm.reset() ;
        vm.showState() ;
    }
 
}
 
