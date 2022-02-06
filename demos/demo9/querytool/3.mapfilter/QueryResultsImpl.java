
import java.util.ArrayList;

public class QueryResultsImpl implements QueryResults {

    private ArrayList<String> results = new ArrayList<String>()  ;

    public void fetchData()
    {
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
    }

	public QueryResultsIterator createIterator() {
		return new QueryResultsIteratorImpl( results );
	}
	 
}
 
