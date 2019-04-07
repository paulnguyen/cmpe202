all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;
	rm -rf build/*

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

checkstyle:
	gradle check
	
spotbugs:
	gradle spotbugsMain

codesmells:
	gradle smartsmells

run: jar
	java -cp build/libs/inputmask-all.jar Main

