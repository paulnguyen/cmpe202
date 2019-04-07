all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

compile:
	groovyc -cp hamcrest-core-1.3.jar:junit-4.12.jar *.groovy
	
run:
	groovy -cp hamcrest-core-1.3.jar:junit-4.12.jar:. GumballMachineTest
	
	