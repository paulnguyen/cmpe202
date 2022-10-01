
public class UnlimitedToppings extends LeafDecorator
{
    private String[] options ;
    
    
    public UnlimitedToppings( String d )
    {
        super(d) ;
    }
    
    // free toppings 
    public void setOptions( String[] options )
    {
        this.options = options ;
    }
    
    public String getDescription() 
    {
        String desc = "" ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }
    
}