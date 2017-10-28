
import java.util.ArrayList;
import java.util.UUID;



public class QueryTool {
    
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
    
	public ArrayList<String> map(QueryResults rs)
	{
		ArrayList<String> out = new ArrayList<>() ;
        QueryResultsIterator iter =  rs.createIterator() ;
        while ( !iter.isDone()  )
        {
			String key = UUID.randomUUID().toString();
			if ( Integer.parseInt(iter.currentItem()) % 2 == 0 ) {
        		out.add( key + " => " + iter.currentItem() ) ;			
			}
            iter.next();
        }
		return out ;
	}    
    
    public int reduce(ArrayList<String> inputList)
	{
		int sum = 0 ;
		for (String item: inputList) {
			String[] parts = item.split("=> ");
			int val = Integer.parseInt(parts[1]);
    		sum += val ;
		}
		return sum ;
	}        
    
    public static void main(String[] args) {
        QueryTool q = new QueryTool() ;
        QueryResults dataset = q.query( "select * from test" ) ;
        ArrayList<String> mapset = q.map(dataset) ;
        System.out.println( "\nMap..." ) ;
        for (String item : mapset ) {
    		System.out.println( item ) ;
    	}
        System.out.println( "\nReduce..." ) ;
        int sum = q.reduce(mapset) ;
        System.out.println( sum ) ;
    } 
}
 
