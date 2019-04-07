package iterator;

import java.util.ArrayList;

public class QueryResultsImpl implements QueryResults {

    private ArrayList<String> results = new ArrayList<String>()  ;

    public void fetchData()
    {
        // setup a sample list
        results.add( "Item 1") ;
        results.add( "Item 2") ;
        results.add( "Item 3") ;
        results.add( "Item 4") ;
        results.add( "Item 5") ;
        results.add( "Item 6") ;
        results.add( "Item 7") ;
        results.add( "Item 8") ;
        results.add( "Item 9") ;
        results.add( "Item 10") ;
    }

	public QueryResultsIterator createIterator() {
		return new QueryResultsIteratorImpl( results );
	}
	 
}
 
