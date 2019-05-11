
ktbase=$(subst .kt, $(nullstring), $(kotlin))
ktprog=$(strip $(ktbase))

all: clean

clean: 
	find . -name "*.jar" -exec rm -rf {} \;	

kotlin-compile:
	kotlinc $(ktprog).kt -include-runtime -d $(ktprog).jar

kotlin-run: kotlin-compile
	java -jar $(ktprog).jar

swift-run:
	swift $(swift)

groovy-run:
	groovy $(groovy)

javascript-run:
	node $(javascript)

ruby-run:
	ruby $(ruby)

## use ":q" to quit
groovy:
	groovyConsole

## use ":q" to quit
swift:
	swift

## use ".exit" to quit
javascript:
	node

## use ":quit" to quit
kotlin:
	kotlinc-jvm

## type "exit" to quit
ruby:
	irb --simple-prompt