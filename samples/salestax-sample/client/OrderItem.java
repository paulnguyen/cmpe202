
/**
 * OrderItem Class
 * 
 * @author Paul Nguyen
 * @version 1.0
 */
public class OrderItem implements IOrderItem
{
    private String description;
    private Double price;
    private int qty;

    /**
     * Constructor for objects of class OrderItem
     */
    public OrderItem(String description, Double price, int qty)
    {
        this.description = description ;
        this.price = price ;
        this.qty = qty ;
    }

    /**
     * Return base price of Item
     * 
     * @return     Base Price 
     */
    public Double getBasePrice() 
    {
        return this.price * this.qty ;
    }
 
    /**
     * Return Taxed Price of Item
     * 
     * @return     Taxed Price 
     */
    public Double getTaxedPrice() 
    {
        return this.price * this.qty ;
    }    
    
    /**
     * Return Product Description
     * 
     * @return     the sum of x and y 
     */    
    public String getDescription() 
    {
        return this.qty + " - " + this.description ;
    }
}
