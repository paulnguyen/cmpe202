

all: clean

clean: 
	rm -f hello.jar

compile:
	kotlinc hello.kt -include-runtime -d hello.jar

run:
	java -jar hello.jar

help:
	kotlinc -help

lib:
	kotlinc hello.kt -d hello.jar

runlib:
	kotlin -classpath hello.jar HelloKt

repl:
	kotlinc-jvm

runscript:
	kotlinc -script hello.kts /Users


