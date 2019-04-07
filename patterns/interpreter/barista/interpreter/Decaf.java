
package interpreter ;

public class Decaf implements Expression
{
    public String interpret(String option)
    {
        String[] split1 = option.split("\\[") ;
        String[] split2 = split1[1].split("\\]") ;
        String value = split2[0] ;
        if ( "1/2".equals(value) )
            return "Half Decaf\n" ;
        else if ( "YES".equals(value) )
            return "Decaf\n" ;
        else if ( "NO".equals(value) )
            return "" ; // Regular Caffeine is default
        else
            return "Unkown Decaf Option: " + value + "\n" ;
    }   
}
