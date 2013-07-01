package state;

public class VirtualMachineManager {
 
	VirtualMachineState poweredOnState ;
    VirtualMachineState poweredOffState ;
    VirtualMachineState suspendedState ;
    VirtualMachineState currentState ;

    public VirtualMachineManager()
    {
        poweredOnState = new VmPoweredOn(this);
        poweredOffState = new VmPoweredOff(this);
        suspendedState = new VmSuspended(this);
        currentState = poweredOffState ;
    }
	 
	public void powerOn() {
        System.out.println( "powering on...");
	    currentState.doPowerOn();
	}
	 
	public void powerOff() {
        System.out.println( "powering off...");
	    currentState.doPowerOff();
	}
	 
	public void suspend() {
        System.out.println( "suspending...");
	    currentState.doSuspend();
	}
	 
	public void reset() {
        System.out.println( "reset vm...");
	    currentState.doReset();
	}
	 
	void setState(VmStates nextState) {
        switch( nextState ) {
            case OFF :          currentState = poweredOffState ; break ;
            case ON :           currentState = poweredOnState ; break ;
            case SUSPENDED:     currentState = suspendedState ; break ;
        }

	}
    
    public void showState()
    {
        System.out.println( "Current State: " + currentState.getClass().getName());
    }
	 
}
 
