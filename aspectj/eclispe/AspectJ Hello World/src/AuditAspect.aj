
public aspect AuditAspect {

	private static boolean BYPASS = false ;
	
	Log audit = new Log() ;
	
	pointcut accountOperation() : call (* Account.*(..)) && !call(* Account.toString()) ;
	pointcut accountExecution() : execution (* Account.*(..)) && !execution (* Account.toString(..)) ;
	pointcut marker() : call(@Marker * Account.*(..)) ;
	
	before() : accountOperation() {
		Object target = thisJoinPoint.getTarget();
		audit.store("Before: " + thisJoinPoint + " Target: " + target ) ;
	}
	
	after() : accountExecution() {
		Object target = thisJoinPoint.getTarget();
		audit.store("After: " + thisJoinPoint + " Target: " + target ) ;
	}
	
	Object around(): marker()  {
		System.out.println("Around: Intercepted message: " +
				thisJoinPointStaticPart.getSignature().getName());
		System.out.println("Around: in class: " +
		          thisJoinPointStaticPart.getSignature().getDeclaringType().getName());
		System.out.println("Around: Running original method: ..." );
		Object result = proceed();
		System.out.println("Around result: " + result );
		if ( BYPASS )
			return 0.0 ;
		else
			return result;
	}	
		
}
