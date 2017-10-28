
import java.util.function.*;

public class Main {

	public static void repeatMessage1(String text, int count) {
	    Runnable r = () -> {
	        for (int i = 0; i < count; i++) {
	            System.out.println(text + " #" + i);
	        }
	    };
	    new Thread(r).start();
	}    

	/*
	public static void repeatMessage2(String text, int count) {
		for (int i = 0; i < count; i++) {
    		new Thread(() -> System.out.println(text + " #" + i)).start();
        	// Error—cannot capture i
		}
	}
	*/

    public static void main(String[] args) {
		Main.repeatMessage1( "Hello", 5 ) ;    
    }            

}

/*
	FROM:  Core Java® for the Impatient

	A Lambda Expression Has:
	
	1. A block of code
	2. Parameters
	3. Values for the free variables
	   (the variables that are not parameters and not defined inside the code)  
	4. References to variables in enclosing scope.
	   (In a lambda expression, you can only reference variables whose value doesn’t change.)
	   
	The technical term for a block of code together with the values of free variables 
	is a closure. In Java, lambda expressions are closures.    

*/