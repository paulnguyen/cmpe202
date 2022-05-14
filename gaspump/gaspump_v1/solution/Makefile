all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;
	rm -rf build/*
	rm -f *.log

init:
	gradle init
	mkdir -p libs
	mkdir -p src/main/java
	mkdir -p src/test/java

compile:
	gradle build -x test --warning-mode all

test:
	gradle test

jar: compile
	gradle shadowJar

run: jar
	java -cp build/libs/gaspump-all.jar Main 2>debug.log

