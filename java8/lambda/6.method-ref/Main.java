
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

       	Function<String, Integer> strToInt = Integer::parseInt ;  // "::" is method reference
       	Function<Integer, Integer> addOne = (Integer x) -> x + 1 ; // function literal

		Integer x = strToInt.apply( "1" ) ;
		System.out.println( x ) ;
		
		Integer y = addOne.apply( 1 ) ;  // autoboxed from "int" to "Integer"
										 // http://docs.oracle.com/javase/1.5.0/docs/guide/language/autoboxing.html
		System.out.println( y ) ;
		
    }            

}

