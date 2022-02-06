
import java.util.stream.* ;

public class CountPrimes
{

    /** Bloated Version */

    public long countPrimes(int upTo)
    {
        long tally = 0;

        // Responsibility #3 - Control Structure -- i.e. iteration (what if we want to parallelize?)
        for (int i = 1; i < upTo; i++)
        {
            boolean isPrime = true;
            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    isPrime = false; // Responsibility #1 - Look for Primes
                }
            }
            if (isPrime)
            {
                tally++; // Responsibility #2 - Count Primes
            }
        }
        return tally;
    }

    /** Refactored Version */

    public long countPrimesRefactored(int upTo)
    {
        long tally = 0;
        for (int i = 1; i < upTo; i++)
        {
            if (isPrimeRefactored(i))
            {
                tally++;
            }
        }
        return tally;
    }

    private boolean isPrimeRefactored(int number)
    {
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }


    /** Java Streams API Version */


    public long countPrimesStreams(int upTo)
    {
        return IntStream.range(1, upTo)
               .filter(this::isPrimeStreams)
               .count();
    }

    private boolean isPrimeStreams(int number)
    {
        return IntStream.range(2, number)
               .allMatch(x -> (number % x) != 0);
    }


    /** Main Test Class */

    public static void main(String[] args)
    {
        CountPrimes example = new CountPrimes();
        long count ;

        System.out.println( "*** Bloated Version ***") ;
        count = example.countPrimes( 100 ) ;
        System.out.println( "Num Primes Up to 100: " + count ) ;

        System.out.println( "*** Refactored Version ***") ;
        count = example.countPrimesRefactored( 100 ) ;
        System.out.println( "Num Primes Up to 100: " + count ) ;

      	System.out.println( "*** Java Streams API Version ***") ;
        count = example.countPrimesStreams( 100 ) ;
        System.out.println( "Num Primes Up to 100: " + count ) ;

    }

}


