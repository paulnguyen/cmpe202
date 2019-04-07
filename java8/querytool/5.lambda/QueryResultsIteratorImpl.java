
import java.util.ArrayList;

public class QueryResultsIteratorImpl implements QueryResultsIterator {

    private ArrayList<String> results ;
    private int cursor ;
    private int max ;

    public QueryResultsIteratorImpl(ArrayList<String> r)
    {
        results = r ;
        cursor = 0 ;
        max = r.size() ;
    }

    public String first() {
		return results.get( 0 ) ;
	}

	public String next() {
        cursor++ ;
        if ( !isDone() )
		    return results.get( cursor ) ;
        else
            return "<end>" ;
	}

	public String currentItem() {
		return results.get( cursor ) ;
	}

	public boolean isDone() {
		return (cursor == max) ;
	}
	 
}
 
