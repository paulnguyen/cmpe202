
import java.util.ArrayList;
import java.util.UUID;

public class QueryTool {

 	interface Filter {
      boolean operation(String item);
   	}    

 	interface Reducer {
      int operation(int item, int accumulator);
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

    public int reduce(ArrayList<String> inputList, Reducer r)
	{
		int sum = 0 ;
		for (String item: inputList) {
			String[] parts = item.split("=> ");
			int val = Integer.parseInt(parts[1]);
    		sum = r.operation( val, sum ) ;
		}
		return sum ;
	}     
    
    public static void main(String[] args) {
    
        QueryTool q = new QueryTool() ;
        ArrayList<String> dataset = q.query( "select * from test" ) ;
        
        // filters functions
      	Filter evens = (a) -> ((Integer.parseInt(a)) % 2) == 0;		
      	Filter odds  = (a) -> ((Integer.parseInt(a)) % 2) != 0;		
        
        // Java's built-in iterator
        ArrayList<String> mapset = q.map(dataset, evens) ;
        System.out.println( "\nMap..." ) ;
		mapset.forEach( e -> System.out.println(e)) ;

        // reducer functions
      	Reducer sumfunc = (i,a) -> { return (a += i) ; } ;		
      	Reducer sumdiv2 = (i,a) -> { return (a += (i/2)) ; } ;		

		// Reduce		
        System.out.println( "\nReduce..." ) ;
        int sum = q.reduce(mapset, sumdiv2 ) ;
        System.out.println( sum ) ;
		
		
    	
    } 
}
 
