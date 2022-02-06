public class Burger extends LeafDecorator
{
    private String[] options ;
    
    
    public Burger( String d )
    {
        super(d) ;
    }
    
    public void setOptions( String[] options )
    {
        this.options = options ;
        for ( int i = 0; i<options.length; i++ )
        {
            if ( "1/3lb.".equals(options[i]) ) this.price += 9.00 ;
            if ( "1/2lb.".equals(options[i]) ) this.price += 12.00 ;
            if ( "1lb.".equals(options[i]) ) this.price += 18.00 ;
            if ( "In A Bowl".equals(options[i]) ) this.price += 1.50 ;
            if ( "Organic Bison*".equals(options[i]) ) this.price += 4.00 ;
            if ( "Ahi Tuna*".equals(options[i]) ) this.price += 4.00 ;
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
