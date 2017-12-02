
/**
 * Order Item Decorator Interface
 * 
 * @author Paul Nguyen 
 * @version 1.0
 */
public interface IOrderItem
{
    Double getBasePrice() ;
    Double getTaxedPrice() ;
    String getDescription() ;
}
