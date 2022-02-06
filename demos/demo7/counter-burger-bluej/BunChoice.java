
public class BunChoice extends LeafDecorator
{
    private String[] options ;
    
    
    public BunChoice( String d )
    {
        super(d) ;
    }
    
    public void setOptions( String[] options )
    {
        this.options = options ;
       for ( int i = 0; i<options.length; i++ )
        {
            if ( "Gluten-Free Bun".equals(options[i]) ) this.price += 1.00 ;
            else if ( "Hawailan Bun".equals(options[i]) ) this.price += 1.00 ;
            else if ( "Pretzel Bun".equals(options[i]) ) this.price += 0.50 ;
            else this.price += 0.00 ;
        }
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