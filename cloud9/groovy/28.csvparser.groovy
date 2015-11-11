
import com.xlson.groovycsv.CsvParser


def processFile( csvfile ) {

	def CSVFILE = "" 
	new File(csvfile).eachLine { csvline, number ->  
		if  (number > 1 )
			CSVFILE = CSVFILE + "\n" + csvline
	}	

	// Column Layout Expected from CSV file
	def data = new CsvParser().parse(CSVFILE, readFirstLine:false,
		    columnNames:['cur', 'ordtyp', 'soldto', 'billto', 'shipto', 'po', 'podate', 'quote', 'ircd1', 'ircd2', 
		                 'paytrm', 'tax', 'mgrname', 'comments', 'shiptoatt', 'soldtoatt', 'invatt', 'qty', 'disamt', 
						 'prodnum', 'listprice', 'hpidcode', 'invcomment', 'invnum', 'invid', 'totalcharge'
						])

	def map = [:]					
	for(line in data) {

			//println "{$line}"				
			//println "${line.invid}"

			if ( map.containsKey(line.invid) )
			{
				list = map.get(line.invid)
				list.add(line)
				map.put(line.invid, list)
			}
			else
			{
				list = []
				list.add(line)
				map.put(line.invid, list)
			}

	}

	println map['5578'].size()
	println map['5577'].size()
	println map['5582'].size()
	map['5582'].each { println "$it.invcomment" }

}

filename = "./input/test.csv"
processFile( filename ) ;