

base=$(subst .kt, $(nullstring), $(code))
prog=$(strip $(base))

all: clean

clean: 
	find . -name "*.jar" -exec rm -rf {} \;	

compile:
	kotlinc $(prog).kt -include-runtime -d $(prog).jar

run: compile
	java -jar $(prog).jar

help:
	kotlinc -help


