all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

compile:
	javac *.java

run: compile
	java -cp . Main
	
