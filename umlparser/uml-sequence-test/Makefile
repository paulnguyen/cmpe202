all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;
	
compile:
	javac -cp junit-4.12.jar *.java

run: compile
	java -cp .:./junit-4.12.jar:./hamcrest-core-1.3.jar org.junit.runner.JUnitCore ObserverTest



	