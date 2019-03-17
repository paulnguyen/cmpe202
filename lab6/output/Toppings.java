public class Toppings extends LeafDecorator
{
    private String[] options ;
    
    
    public Toppings( String d )
    {
        super(d) ;
    }
    
    // All toppings free
    public void setOptions( String[] options )
    {
        this.options = options ;
        this.price = 0.0;
    }
    
    public String getDescription() 
    {
        String desc = "   " ;
        for ( int i = 0; i<options.length/2; i++ )
        {
            if (i>0) desc += "  " + options[i] ;
            else desc = options[i] ;
        }        
        
        for ( int i = options.length/2; i<options.length; i++ )
        {
            if (i>0) desc += " ->| " + options[i] ;
            else desc = options[i] ;
        }
        return desc ;
    }
    
}