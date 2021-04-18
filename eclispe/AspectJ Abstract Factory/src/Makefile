all: clean

clean: 
	rm *.class
	rm abstract_factory/*.class

java:
	ajc -1.5 abstract_factory/*.java
	ajc -1.5 *.java
	
prius:
	ajc -1.5 abstract_factory/*.java
	ajc -1.5 *.java Prius.aj
	
tesla:
	ajc -1.5 abstract_factory/*.java
	ajc -1.5 *.java Tesla.aj
	
volvo:
	ajc -1.5 abstract_factory/*.java
	ajc -1.5 *.java Volvo.aj

run:
	java Main