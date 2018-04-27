
import java.util.ArrayList;
import java.util.UUID;



public class QueryTool {

 	interface Filter {
      boolean operation(String item);
   	}    

    
    public class Query {
        public QueryResults executeQuery(String query) {
            System.out.println( "Executing Query: " + query );
            QueryResults resultSet = new QueryResultsImpl() ;
            resultSet.fetchData();
            return resultSet ;
        }
    }

    public QueryResults query(String str)
    {
        Query q = new Query() ;
        QueryResults resultSet = q.executeQuery(str);
        return resultSet ;
	}
    
	public ArrayList<String> map(QueryResults rs, Filter f)
	{
		ArrayList<String> out = new ArrayList<>() ;
        QueryResultsIterator iter =  rs.createIterator() ;
        while ( !iter.isDone()  )
        {
			String key = UUID.randomUUID().toString();
			if ( f.operation(iter.currentItem()) ) {
        		out.add( key + " => " + iter.currentItem() ) ;			
			}
            iter.next();
        }
		return out ;
	}    
    
    
    public static void main(String[] args) {
        QueryTool q = new QueryTool() ;
        QueryResults dataset = q.query( "select * from test" ) ;
        
        // filter functions
      	Filter evens = (a) -> ((Integer.parseInt(a)) % 2) == 0;		
      	Filter odds  = (a) -> ((Integer.parseInt(a)) % 2) != 0;		
        
        ArrayList<String> mapset = q.map(dataset, evens) ;
        for (String item : mapset ) {
    		System.out.println( item ) ;
    	}
    } 
}
 
