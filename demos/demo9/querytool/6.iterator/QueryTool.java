
import java.util.ArrayList;
import java.util.UUID;

public class QueryTool {

 	interface Filter {
      boolean operation(String item);
   	}    

    public ArrayList<String>  query(String query)
    {
    	ArrayList<String> results = new ArrayList<String>()  ;
    	
        // setup a sample list
        results.add( "1") ;
        results.add( "2") ;
        results.add( "3") ;
        results.add( "4") ;
        results.add( "5") ;
        results.add( "6") ;
        results.add( "7") ;
        results.add( "8") ;
        results.add( "9") ;
        results.add( "10") ;
        
        // return results
        return results ;
    }
    
	public ArrayList<String> map(ArrayList<String> rs, Filter f)
	{
		ArrayList<String> out = new ArrayList<>() ;
		rs.forEach( e -> {
			String key = UUID.randomUUID().toString();
			if ( f.operation(e) ) {
        		out.add( key + " => " + e ) ;			
			}
		  }	
		) ;				
		return out ;
	}    
    
    
    public static void main(String[] args) {
    
        QueryTool q = new QueryTool() ;
        ArrayList<String> dataset = q.query( "select * from test" ) ;
        
        // filters functions
      	Filter evens = (a) -> ((Integer.parseInt(a)) % 2) == 0;		
      	Filter odds  = (a) -> ((Integer.parseInt(a)) % 2) != 0;		
        
        // Java's built-in iterator
        ArrayList<String> mapset = q.map(dataset, odds) ;
		mapset.forEach( e -> System.out.println(e)) ;
    	
    } 
}
 
