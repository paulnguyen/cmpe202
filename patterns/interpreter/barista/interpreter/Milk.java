

package interpreter ;

public class Milk implements Expression
{
    public String interpret(String option)
    {
        String[] split1 = option.split("\\[") ;
        String[] split2 = split1[1].split("\\]") ;
        String value = split2[0] ;
        if ( "WH".equals(value) )
            return "Whole Milk\n" ;
        else if ( "NF".equals(value) )
            return "Non-Fat Milk\n" ;
        else if ( "1".equals(value) )
            return "Non-Fat 1%\n" ; 
        else if ( "2".equals(value) )
            return "Non-Fat 2%\n" ; 
        else
            return "Unkown Milk Option: " + value + "\n" ;
    }   
}