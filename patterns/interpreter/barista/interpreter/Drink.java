

package interpreter ;

public class Drink implements Expression
{
    public String interpret(String option)
    {
        String[] split1 = option.split("\\[") ;
        String[] split2 = split1[1].split("\\]") ;
        String value = split2[0] ;
        if ( "A".equals(value) )
            return "Caffe Americano\n" ;
        else if ( "L".equals(value) )
            return "Latte\n" ;
        else if ( "M".equals(value) )
            return "Caffe Mocha\n" ; 
        else if ( "C".equals(value) )
            return "Cappuccino\n" ; 
        else if ( "CM".equals(value) )
            return "Caramel Macchiato\n" ; 
        else if ( "CDL".equals(value) )
            return "Cinnamon Dolce Latte\n" ; 
        else if ( "E".equals(value) )
            return "Espresso\n" ; 
        else if ( "ECP".equals(value) )
            return "Espresso Con Panna\n" ; 
        else
            return "Unkown Drink Option: " + value + "\n" ;
    }   
}