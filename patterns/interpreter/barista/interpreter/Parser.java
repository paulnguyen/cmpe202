

package interpreter ;

public class Parser implements Expression
{
    private String command ;
    private String decaf = null ;
    private String shots = null ;
    private String milk = null ;
    private String drink = null ;
    
    public String interpret(String expr)
    {
        command = expr ;
        
        // set up command
        String[] tokens = command.split(":");
        //System.out.println("Count of tokens = " + tokens.length);
        
        // get options
        //System.out.println( tokens[1].trim() ) ; 
        String[] options = tokens[1].trim().split(" ") ;
        for(String option : options) {
            String opt = option.trim() ;
            //System.out.println(opt);
            if ( opt.startsWith("Decaf[") ) { decaf = opt ; }
            if ( opt.startsWith("Shots[") ) { shots = opt ; }
            if ( opt.startsWith("Milk[") )  { milk = opt ; }
            if ( opt.startsWith("Drink[") ) { drink = opt ; }            
        }        
        return (decaf==null ? "" : (new Decaf()).interpret(decaf)) + 
               (shots==null ? "" : (new Shots()).interpret(shots)) +
               (milk==null ? ""  : (new Milk()).interpret(milk)) +
               (drink==null ? ""  : (new Drink()).interpret(drink))
        ;
    }
}
