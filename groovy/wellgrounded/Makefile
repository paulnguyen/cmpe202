all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;
	
ex8:
	groovyc EX8*.groovy
	groovy -cp . EX8_GroovyClassTest.groovy

debug:
	javap -private -l EX8_GroovyClassA

	
	
