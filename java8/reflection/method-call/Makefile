all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

compile:
	javac *.java

run-on: compile
	java -cp . GumballMachine debugOn

run-off: compile
	java -cp . GumballMachine debugOff

main: compile
	java -cp . Main 
	
