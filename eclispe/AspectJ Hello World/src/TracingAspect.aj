
import org.aspectj.lang.reflect.* ;
import org.aspectj.lang.* ;

public aspect TracingAspect {
	
	private int callDepth;
	private static boolean VERBOSE = true ;

	// trace all methods
	pointcut traced() : !within(TracingAspect) && execution(* Foo.*(..)) && !execution (* Account.toString(..)) ;

	// before advice -- thisJoinPoint is a special object that contains 
	//                  information about the join point
	before() : traced() {
		print("Before", thisJoinPoint); 
		Object target = thisJoinPoint.getTarget();	
		if (VERBOSE) {
			System.out.println( "---> Target: " + target ) ;
			System.out.println( "---> entering: " + thisJoinPoint);
			System.out.println( "--->   w/args: " + thisJoinPoint.getArgs());
			System.out.println( "--->       at: " + thisJoinPoint.getSourceLocation());
			printParameters(thisJoinPoint) ;
		}
		callDepth++;
	}

	// after advice
	after() : traced() {		
		callDepth--;
		print("After", thisJoinPoint);
	}

	// print trace messages
	private void print(String prefix, Object message) {
		for (int i = 0; i < callDepth; i++) {
			System.out.print(" ");
		}
		System.out.println(prefix + ": " + message);
	}
	
	// print method args
	static private void printParameters(JoinPoint jp) {
		System.out.println("---> Arguments: " );
		Object[] args = jp.getArgs();
		String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
		Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
		for (int i = 0; i < args.length; i++) {
			System.out.println(	"--->   "  + i + ". " + names[i] +
								" : " +            types[i].getName() +
								" = " +            args[i]);
		}
	}	
	
}