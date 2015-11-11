
import groovy.io.*

/********** PROCESS INPUT FILES **********/
// REF1: http://groovy.codehaus.org/Input+Output
// REF2: http://pleac.sourceforge.net/pleac_groovy/directories.html
// processFile ( "./input/test.csv" ) ;

println( " " )
println( "==========================")			
println( " PROCESSING INPUT FILES ")
println( "==========================")			

def inputDIR = new File('./input/')
def dirs = []
inputDIR.eachFileMatch(FileType.ANY, ~/.*\.csv/) {
	def filename = "./input/" + it.name ;
	println "Processing file: $it.name" ;
}
