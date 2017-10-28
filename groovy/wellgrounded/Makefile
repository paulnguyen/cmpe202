all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

compile:
	groovyc $(src)

run:
	groovy $(src)

debug:
	javap -private -l $(class)

	
	
