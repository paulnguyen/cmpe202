
import java.util.function.*;
import java.lang.*;

public class Main {	

    public static void main(String[] args) {

		// lambda expression
		Function<String, Integer> f1 = (String input) -> input.length() + 10 ;

		// lambda expression with code block
		Function<String, Integer> f2 = (String input) -> {
   			int size = input.length() ;
   			if (size < 10) return -1;
   			else return 10;
		} ;
		 
		// lambda expression with no paramters
		Runnable task = () -> { for (int i = 0; i < 1000; i++) System.out.println("Doing work..."); } ;
		 
    }    
    
    /** Other Examples:

		(int x, int y) -> x + y 
		() -> 42 
		(String s) -> { System.out.println(s); } 
		
	**/
          
}

/*

	https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
	https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
	
	Interface Function<T,R>

    	Type Parameters:
        	T - the type of the input to the function
        	R - the type of the result of the function

    Functional Interface:
        
        This is a functional interface and can therefore be used as 
        the assignment target for a lambda expression or method reference. 	

*/

