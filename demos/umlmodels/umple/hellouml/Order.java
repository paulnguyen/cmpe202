/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 1 "hellouml.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes

  /**
   * attributes
   */
  private Date dateReceived;
  private boolean isPrepaid;
  private String number;
  private Money price;

  //Order Associations
  private List<OrderLine> lineitems;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(Date aDateReceived, boolean aIsPrepaid, String aNumber, Money aPrice, Customer aCustomer)
  {
    dateReceived = aDateReceived;
    isPrepaid = aIsPrepaid;
    number = aNumber;
    price = aPrice;
    lineitems = new ArrayList<OrderLine>();
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public OrderLine getLineitem(int index)
  {
    OrderLine aLineitem = lineitems.get(index);
    return aLineitem;
  }

  /**
   * associations
   */
  public List<OrderLine> getLineitems()
  {
    List<OrderLine> newLineitems = Collections.unmodifiableList(lineitems);
    return newLineitems;
  }

  public int numberOfLineitems()
  {
    int number = lineitems.size();
    return number;
  }

  public boolean hasLineitems()
  {
    boolean has = lineitems.size() > 0;
    return has;
  }

  public int indexOfLineitem(OrderLine aLineitem)
  {
    int index = lineitems.indexOf(aLineitem);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfLineitems()
  {
    return 0;
  }

  public boolean addLineitem(OrderLine aLineitem)
  {
    boolean wasAdded = false;
    if (lineitems.contains(aLineitem)) { return false; }
    lineitems.add(aLineitem);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLineitem(OrderLine aLineitem)
  {
    boolean wasRemoved = false;
    if (lineitems.contains(aLineitem))
    {
      lineitems.remove(aLineitem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLineitemAt(OrderLine aLineitem, int index)
  {  
    boolean wasAdded = false;
    if(addLineitem(aLineitem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLineitems()) { index = numberOfLineitems() - 1; }
      lineitems.remove(aLineitem);
      lineitems.add(index, aLineitem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLineitemAt(OrderLine aLineitem, int index)
  {
    boolean wasAdded = false;
    if(lineitems.contains(aLineitem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLineitems()) { index = numberOfLineitems() - 1; }
      lineitems.remove(aLineitem);
      lineitems.add(index, aLineitem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLineitemAt(aLineitem, index);
    }
    return wasAdded;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    lineitems.clear();
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeOrder(this);
  }


  /**
   * methods
   */
  // line 12 "hellouml.ump"
   public void dispatch(){
    
  }

  // line 13 "hellouml.ump"
   public void close(){
    
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null")
     + outputString;
  }
}