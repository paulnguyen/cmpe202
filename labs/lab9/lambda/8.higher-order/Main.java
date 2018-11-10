
import java.util.*;
import java.util.function.*;


public class Main {

	/*
		FROM:  Core Java® for the Impatient
	
		Suppose sometimes we want to sort an array of strings in ascending order 
		and other times in descending order. We can make a method that produces 
		the correct comparator:   
		
	*/	
	    

    public static Comparator<String> compareInDirecton(int direction) {
        return (x, y) -> direction * x.compareTo(y);
    }
    
    public static Comparator<String> reverse(Comparator<String> comp) {
        return (x, y) -> -comp.compare(x, y);
    }

    public static void main(String[] args) {
		String[] words = { "Mary", "had", "a", "little", "lamb" };

 		Arrays.sort(words, compareInDirecton(-1));
        System.out.println(Arrays.toString(words));
        
        Arrays.sort(words, reverse(String::compareToIgnoreCase));
        System.out.println(Arrays.toString(words));    
    }            

}



