/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/



/**
 * { if Order.customer.getCreditRating is "poor" then Order.isPrepaid must be true }
 */
// line 20 "hellouml.ump"
public class OrderLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderLine Attributes

  /**
   * attributes
   */
  private int quantity;
  private Money price;

  //OrderLine Associations
  private Product product;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderLine(int aQuantity, Money aPrice, Product aProduct)
  {
    quantity = aQuantity;
    price = aPrice;
    if (!setProduct(aProduct))
    {
      throw new RuntimeException("Unable to create OrderLine due to aProduct");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Product getProduct()
  {
    return product;
  }

  public boolean setProduct(Product aNewProduct)
  {
    boolean wasSet = false;
    if (aNewProduct != null)
    {
      product = aNewProduct;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    product = null;
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "product = "+(getProduct()!=null?Integer.toHexString(System.identityHashCode(getProduct())):"null")
     + outputString;
  }
}