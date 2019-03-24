
/**
 * Prepare for selecting premium cheese.
 *
 * @author Chi Tran
 * @version Mar-23-2019
 */
public class PremiumCheese extends LeafDecorator
{
    private String[] options ;
    
    
    public PremiumCheese( String d )
    {
        super(d) ;
    }
    
    // 1 premium cheese 1.50, extra premium cheese +1.50
    public void setOptions( String[] options )
    {
        this.options = options ;
        if ( options.length >= 1 )
            this.price += (options.length) * 1.50 ;
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
