package iterator;

public interface QueryResultsIterator {

	String first();
	String next();
	String currentItem();
	boolean isDone();

}
 
