all: clean reset

clean: 
	find . -name "*.class" -exec rm -rf {} \;
	find . -name .DS_Store -exec rm -rf {} \;
	rm -rf build
	rm -f *.log
	rm -rf .gradle


# Gradle: 		https://guides.gradle.org/creating-new-gradle-builds/
# CircleCI:		https://circleci.com/docs/2.0/language-java/

init:
	gradle init

compile:
	gradle build 

test:
	gradle test

build: compile
	gradle shadowJar


reset:
	mkdir -p output/test0 
	mkdir -p output/test1 
	mkdir -p output/test2 
	mkdir -p output/test3 
	mkdir -p output/test4 
	mkdir -p output/test5 
	mkdir -p output/test6 
	mkdir -p output/test7 
	mkdir -p output/test8 
	mkdir -p output/test9 
	mkdir -p output/test10 	
	mkdir -p output/exam	
	mkdir -p output/starbucks
	mkdir -p output/sequence 	
	rm -rf output/test0/*
	rm -rf output/test1/*
	rm -rf output/test2/*
	rm -rf output/test3/*
	rm -rf output/test4/*
	rm -rf output/test5/*
	rm -rf output/test6/*
	rm -rf output/test7/*
	rm -rf output/test8/*
	rm -rf output/test9/*
	rm -rf output/test10/*	
	rm -rf output/exam/*
	rm -rf output/starbucks/*
	rm -rf output/sequence/*

test0: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test0

test1: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test1

test2: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test2

test3: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test3

test4: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test4

test5: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test5

test6: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test6

test7: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test7

test8: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test8

test9: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test9

test10: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) test10

exam: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) exam

starbucks: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) starbucks

sequence: build
	@echo $(PWD)
	java -cp build/libs/umlparser-all.jar umlparser.Main $(PWD) sequence

	
