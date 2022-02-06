
// https://eclipse.org/aspectj/doc/released/runtime-api/index.html


import org.aspectj.lang.JoinPoint;

public aspect TracingAspect {

	private Sequence seq = new Sequence() ;
	private int callDepth;

	pointcut traced() : !within(TracingAspect) && !within(Sequence) && execution(* *.*(..)) ;

	before() : traced() {
		print("Before", thisJoinPoint);
		callDepth++;
	}

	after() : traced() {
		callDepth--;
		print("After", thisJoinPoint);
		seq.test() ;
	}

	private void print(String prefix, JoinPoint m) {
		for (int i = 0; i < callDepth; i++) {
			System.out.print(".");
		} 
		System.out.print(prefix + ": " + m.getKind() + " " + m.getSignature() );
		System.out.print( " args : [ " ) ;
		for (Object obj : m.getArgs())
		{
			System.out.print( obj + " " ) ;
		}
		System.out.println("]") ;
	}
	
}