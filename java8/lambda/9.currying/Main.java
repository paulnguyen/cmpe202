
import java.util.function.*;

public class Main {

	// f(x,y) = x+y
	public static int add1(int a, int b) {
    	return a + b;
	}

	// f(x,y) ==> g(y) = x + y 
	// Convert add(A, B) into Function<A, B> with a single method ==> B apply(A a)
	public static Function<Integer, Function<Integer, Integer>> add2() {
		return new Function<Integer, Function<Integer, Integer>>() {
			@Override
			public Function<Integer, Integer> apply(final Integer x) {
				return new Function<Integer, Integer>() {
					@Override
					public Integer apply(Integer y) {
						return x + y;
					}
				};
			}
		};
	}

	// Lambda Syntax
	public static Function<Integer, Function<Integer, Integer>> add3() {
    	return x -> y -> x + y;
	}


    public static void main(String[] args) {

		System.out.println( Main.add1(1,2) ) ;
		System.out.println( Main.add2().apply(1).apply(2) ) ;
		System.out.println( Main.add3().apply(1).apply(2) ) ;
		 
    }            

}



// REF: http://baddotrobot.com/blog/2013/07/21/curried-functions/

