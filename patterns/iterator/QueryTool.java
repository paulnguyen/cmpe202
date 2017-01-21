package iterator;

public class QueryTool {
    
    public class Query {
        public QueryResults executeQuery(String query) {
            System.out.println( "Executing Query: " + query );
            QueryResults resultSet = new QueryResultsImpl() ;
            resultSet.fetchData();
            return resultSet ;
        }
    }

    public void runTest()
    {
        Query q = new Query() ;
        QueryResults resultSet = q.executeQuery("select * from test");
        QueryResultsIterator iter =  resultSet.createIterator() ;
        while ( !iter.isDone()  )
        {
            System.out.println( iter.currentItem() );
            iter.next();
        }
    }
 
  public static void main( String [] args )
    {
        QueryTool t = new QueryTool() ;
        t.runTest() ;
    }     
 
}
 
