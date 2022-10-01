
import java.text.DecimalFormat;

public class CustomBurger extends Composite
{
    PriceDecorator decorator = null ;
    
    public CustomBurger ( String d )
    {
        super(d) ;
    }
    
    public void setDecorator( PriceDecorator p )
    {
        this.decorator = p ;
    }
    
    public void printDescription() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println( " " + description + " " + fmt.format(decorator.getPrice()) );
        for (Component obj  : components)
        {
            obj.printDescription();
        }
    }
}

       