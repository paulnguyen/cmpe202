
public aspect ProfilingAspect {
	pointcut publicOperation() : execution(public * *.*(..));

	Object around() : publicOperation() {
		long start = System.nanoTime();
		Object ret = proceed();
		long end = System.nanoTime();
		System.out.println(thisJoinPointStaticPart.getSignature() + " took "
				+ (end - start) + " nanoseconds");
		return ret;
	}
}