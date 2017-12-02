
import java.text.DecimalFormat;

/**
 * ImportDuty Decorator
 * 
 * @author Paul Nguyen 
 * @version 1.0
 */
public class ImportDutyDecorator implements IOrderItem
{
    private IOrderItem base;
    private ITaxObserver order;

    /**
     * Constructor for objects of class ImportDuty
     */
    public ImportDutyDecorator(IOrderItem baseObject, ITaxObserver taxObserver)
    {
        this.base = baseObject ;
        this.order = taxObserver ;
    }

    /**
     * Return Import Taxed Price (Rounded)
     * 
     * @return     Price + Tax
     */
    public Double getTaxedPrice() 
    {
        double price = base.getBasePrice() ;
        double taxrate = 0.05 ; // 5% tax
        //double tax = Order.round(price*taxrate) ;
        double tax = price*taxrate ;
        order.addTax(tax) ;
        //DecimalFormat fmt = new DecimalFormat("0.00");
        //System.out.println( fmt.format(price) ) ;
        //System.out.println( fmt.format(tax) ) ;
        //return Order.round( base.getTaxedPrice() + tax ) ;
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
