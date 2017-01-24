/*

Groovy has several built-in methods that can be utilized with collections (lists and maps). This language level support for collections, combined with function literals, results in a significant reduction of the sort of boilerplate code you’d typically have to write in Java.

each		- iterator
collect		- collects return values (i.e. map in map/reduce)
inject		- processes collection and builds up a return value (i.e. reduce in map/reduce)
findAll		- finds items matching a function literal (predicate function)
max			- max value in collection
min 		- mix value in collection


*/


/** Java 7 Collection (imperative approach) **/

List<String> movieTitles = new ArrayList<>();
movieTitles.add("Seven");
movieTitles.add("Snow White");
movieTitles.add("Die Hard");

println ( "=== Java 7 ===" )

for (String movieTitle : movieTitles)
{
  System.out.println(movieTitle);
}

println ( "==============" )


/** Groovy Way **/

movieTitles = ["Seven", "SnowWhite", "Die Hard"]
println ( "=== Groovy ===" )
movieTitles.each({x -> println x})
println ( "==============" )


/** Groovy Way -- even better, with implicit "it" for function literals with a "single argument"  **/

movieTitles = ["Seven", "SnowWhite", "Die Hard"]
println ( "=== Groovy ===" )
movieTitles.each({println it})
println ( "==============" )



