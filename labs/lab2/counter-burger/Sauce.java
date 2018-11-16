public class Sauce extends LeafDecorator
{
    private String[] options ;
    
    
    public Sauce( String d )
    {
        super(d) ;
    }
    
    // 1 sauce free, extra +.75
    public void setOptions( String[] options )
    {
        this.options = options ;
        if ( options.length > 1 )
            this.price += (options.length-1) * 0.75 ;
    }
    
    public String getDescription() 
    {
        String desc = "   " ;
        for ( int i = 0; i<options.length; i++ )
        {
            if (i>0) desc += " + " + options[i] ;
            else desc = options[i] ;
        }        
        return desc ;
    }
    
}