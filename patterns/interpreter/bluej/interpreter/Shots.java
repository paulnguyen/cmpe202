
public class Shots implements Expression
{
    public String interpret(String option)
    {
        String[] split1 = option.split("\\[") ;
        String[] split2 = split1[1].split("\\]") ;
        String value = split2[0] ;
        if ( "D".equals(value) )
            return "" ; // default shots
        else
            return value + " Shot(s)\n" ;
    }   
}