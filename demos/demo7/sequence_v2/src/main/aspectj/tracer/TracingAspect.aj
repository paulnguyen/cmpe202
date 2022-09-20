
package tracer;

/* AspectJ Documentation
  	- https://www.eclipse.org/aspectj/docs.php
 	- https://www.eclipse.org/aspectj/doc/released/adk15notebook/index.html
 	- https://www.eclipse.org/aspectj/doc/released/progguide/index.html
 	- https://eclipse.org/aspectj/doc/released/runtime-api/index.html
 	- https://www.eclipse.org/aspectj/doc/released/progguide/semantics-joinPoints.html
 	- https://www.eclipse.org/aspectj/doc/released/runtime-api/org/aspectj/lang/JoinPoint.html
 */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;


public aspect TracingAspect {

	private Sequence trace ;
	private int callDepth = 0 ;

	//pointcut traced() : !within(tracer.*) && ( execution(* *.*(..)) || call(*.new (..)) ) ;
	pointcut traced() : !within(tracer.*) && ( execution(* *.*(..)) ) ;

	// before execution advice
	before() : traced() {
		
		String joinpoint = thisJoinPoint.toString();
		if ( joinpoint.equals("execution(void Main.main(String[]))") ) {
			trace = new Sequence( "Main" ) ;
			//Sequence.touch("trace.seq");
		} else {
			String target = thisJoinPoint.getTarget().toString() ;
			String pointcut = thisJoinPoint.toString() ;
			trace.push(target, pointcut, target) ;
		}
		
		print("Before", thisJoinPoint);
		Object target = thisJoinPoint.getTarget();	
		System.out.println( "--->    Level: " + String.valueOf(callDepth) ) ;
		System.out.println( "--->     This: " + thisJoinPoint.getThis() ) ;
		System.out.println( "--->   Target: " + target ) ;
		System.out.println( "---> entering: " + thisJoinPoint);
		System.out.println( "--->   w/args: " + thisJoinPoint.getArgs());
		System.out.println( "--->       at: " + thisJoinPoint.getSourceLocation());	
		saveMethodParameters(thisJoinPoint) ;
		callDepth++;
		
	}

	// after successful return advice
	after() returning(Object r) : traced() {

		String joinpoint = thisJoinPoint.toString();
		if ( joinpoint.equals("execution(void Main.main(String[]))") ) {
			//trace.prettyPrint();
			trace.saveJSON();
			trace.generateDSL() ;
			trace.saveDSL() ;
			//Sequence.touch("trace.png");
		} else {
			String ret = "" ;
			if ( r != null )
				ret = r.toString();
			trace.pop( ret ) ;
		}
		
		callDepth--;
		print("After Returning", thisJoinPoint);
		System.out.println( "--->     Returning: " + r ) ; 
	}

	// after exception advice
	after() throwing(Exception e) : traced() {

		String joinpoint = thisJoinPoint.toString();
		if ( joinpoint.equals("execution(void Main.main(String[]))") ) {
			//trace.prettyPrint();
			trace.saveJSON();
			trace.generateDSL() ;
			trace.saveDSL() ;
			//Sequence.touch("error.png");
		} else {
			trace.pop();
		}
		
		callDepth--;
		print("After Exception", thisJoinPoint);
		System.out.println( "--->     Exception: " + e ) ; 
	}
	
	// print joinpoint details
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
	
	// save method args
	private void saveMethodParameters(JoinPoint jp) {
		System.out.println( "---> Arguments <---") ;
		Object[] args = jp.getArgs();
		String[] names = ((CodeSignature)jp.getSignature()).getParameterNames();
		Class[] types = ((CodeSignature)jp.getSignature()).getParameterTypes();
		for (int i = 0; i < args.length; i++) {
			trace.addArg( names[i], types[i].getName(), args[i].toString() ) ;
			System.out.println(	"--->   "  + i + ". " + names[i] +
								" : " +            types[i].getName() +
								" = " +            args[i]);
		}
	}	
	
}