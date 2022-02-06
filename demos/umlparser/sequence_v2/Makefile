all: clean

clean: 
	gradle clean
	rm -f *.seq
	rm -f *.png
	rm -f *.json
	
build:
	gradle build

run: build
	export TRACE_OUTPUT=.
	gradle run

trace:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar --headless trace.seq
	