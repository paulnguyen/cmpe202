import java.util.ArrayList;
import java.text.DecimalFormat;
import java.lang.Math ;

/**
 * Order Class
 * 
 * @author Paul Nguyen 
 * @version 1.0
 */
public class Order implements ITaxObserver
{
    private ArrayList<IOrderItem> lineItems ;
    private Double totalTax ;
    private Double orderTotal ;

    /**
     * Constructor for objects of class Order
     */
    public Order()
    {
        lineItems = new ArrayList<IOrderItem>() ;
        totalTax = 0.0 ;
        orderTotal = 0.0 ;
    }

    /**
     * Add an Order Line to the Order
     * 
     * @param  item   Order Line
     */
    public void addLineItem(IOrderItem item)
    {
        lineItems.add( item ) ;
    }

   /**
     * Add tax to the Order (Called by Tax Decortators)
     * 
     * @param  taxAmt   Tax Amount
     */    
    public void addTax(Double taxAmt)
    {
        this.totalTax += taxAmt ;
    }

   /**
     * Calculates the Tax Rounding
     * 
     * @param  d   Amount to Round (double)
     */    
    public static double round(double d) {
        return Math.round(d * 100.0) / 100.0 ;
    }

   /**
     * Get the Order Receipt 
     * 
     * @return  String Array of Receipt
     */    
    public synchronized String[] getOutput()
    {
        DecimalFormat fmt = new DecimalFormat("0.00");
        this.totalTax = 0.0 ;
        this.orderTotal = 0.0 ;
        String line = "" ;
        ArrayList<String> output = new ArrayList<String>() ;
        for( IOrderItem item : lineItems )
        {
            String product = item.getDescription() ;
            Double price = item.getTaxedPrice() ;
            this.orderTotal += price ;
            line = product + ": " + fmt.format(price) ;   
            output.add(line) ;
        } 
        line = "Taxes: " + fmt.format(this.totalTax) ;
        output.add(line) ;
        line = "Total: " + fmt.format(Order.round(this.orderTotal)) ;
        output.add(line) ;
        String[] outputArray = new String[output.size()];
        outputArray = output.toArray(outputArray);
        return outputArray ;
    }

   /**
     * Prints the Order Receipt to Console
     * 
     */    
    public synchronized void print()
    {
        System.out.println( "\nOUTPUT: \n" ) ;
        DecimalFormat fmt = new DecimalFormat("0.00");
        this.totalTax = 0.0 ;
        this.orderTotal = 0.0 ;
        for( IOrderItem item : lineItems )
        {
            String product = item.getDescription() ;
            Double price = item.getTaxedPrice() ;
            this.orderTotal += price ;
            System.out.println( product + ": " + fmt.format(price) );            
        } 
        System.out.println( "Taxes: " + fmt.format(this.totalTax) ) ;
        System.out.println( "Total: " + fmt.format(Order.round(this.orderTotal)) ) ;
    }

}

