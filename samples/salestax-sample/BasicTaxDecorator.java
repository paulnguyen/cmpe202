
import java.text.DecimalFormat;

/**
 * BasicTax Decorator.
 * 
 * @author Paul Nguyen 
 * @version 1.0
 */
public class BasicTaxDecorator implements IOrderItem
{
    private IOrderItem base;
    private ITaxObserver order;

    /**
     * Constructor for objects of class BasicTax
     */
    public BasicTaxDecorator(IOrderItem baseObject, ITaxObserver taxObserver)
    {
        this.base = baseObject ;
        this.order = taxObserver ;
    }

    /**
     * Return Based Taxed Price (Rounded)
     * 
     * @return     Price + Tax
     */
    public Double getTaxedPrice() 
    {
        double price = base.getBasePrice() ;
        double taxrate = 0.10 ; // 10 % tax
        //double tax = Order.round(price*taxrate) ;
        double tax = price*taxrate ;
        order.addTax(tax) ;       
        //DecimalFormat fmt = new DecimalFormat("0.00");
        //System.out.println( fmt.format(price) ) ;
        //System.out.println( fmt.format(tax) ) ;
        //return Order.round ( base.getTaxedPrice() + tax ) ;
        return base.getTaxedPrice() + tax  ;
    }

    /**
     * Decorator Passthru (Return Base Price)
     * 
     * @return     Base Price
     */
    public Double getBasePrice() 
    {
        return base.getBasePrice() ;
    }
    
    /**
     * Decorator Passthru (Return Product Description)
     * 
     * @return     Product Description
     */    
    public String getDescription() 
    {
        return base.getDescription() ;
    }
}
