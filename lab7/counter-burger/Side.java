
/**
 * Prepare for selecting premium cheese.
 *
 * @author Chi Tran
 * @version Mar-23-2019
 */
public class Side extends LeafDecorator
{
     private String[] options ;
    
    
    public Side( String d )
    {
        super(d) ;
    }
    
    // Each side costs $3.00
    public void setOptions( String[] options )
    {
        this.options = options ;
        if ( options.length >= 1 )
            this.price += (options.length) * 3.00 ;
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
