all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

compile:
	javac -cp cglib-nodep-3.2.10.jar *.java

run1: compile
	java -cp . Main1
	
run2: compile
	java -cp .:cglib-nodep-3.2.10.jar Main2
	

	
