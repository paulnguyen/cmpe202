all: clean

clean: 
	rm *.class

java:
	ajc -1.5 *.java
	
profile:
	ajc -1.5 *.java ProfilingAspect.aj
	
security:
	ajc -1.5 *.java SecurityAspect.aj
	
aspects:
	ajc -1.5 *.java *.aj

run:
	java Main