
import static ErrorLogger.*

class ErrorLogger {
	
	static batch_status = [:]
	static invoice_status = [:]

	static log_error( filekey, invkey ) {
			batch_status.put( filekey, "ERROR" )
	}

	static log_success( filekey, invkey ) {
			def status = batch_status.get( filekey )
			if ( status == null ) {
				batch_status.put( filekey, "SUCCESS" )
			}
			else if ( status != "ERROR" )
			{
				batch_status.put( filekey, "SUCCESS" )
			}
	}
	
	static inv_status( invkey, status ) {
		invoice_status.put( invkey, status )
	}	
	
	static log_status() {
				
			println( " " )
  			println( "==========================" )			
			println( " BATCH STATUS " )
			println( "==========================" )		
					
			batch_status.each() { key, value -> 
				println( key + " => " + value )
			}

			println( " " )
			println( "==========================")			
			println( " INVOICE STATUS ")
			println( "==========================")			

			invoice_status.each() { key, value -> 
				println( key + " => " + value )
			}		
	}
}


/** TEST **/

ErrorLogger.inv_status( "5578", "HTTP/1.1 401 [ISS.0084.9001] Invalid credentials" )
ErrorLogger.log_error( "test.csv", "5578" )

ErrorLogger.inv_status( "5582", "HTTP/1.1 200" )
ErrorLogger.log_success( "test.csv", "5582" )

ErrorLogger.log_status()
