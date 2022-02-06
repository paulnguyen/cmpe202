/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.util.*;

// line 52 "hellouml.ump"
public class CorporateCustomer extends Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CorporateCustomer Attributes

  /**
   * attributes
   */
  private String contactName;
  private int creditRating;
  private Money creditLimit;

  //CorporateCustomer Associations
  private Employee salesRep;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CorporateCustomer(String aName, Address aAddress, String aContactName, int aCreditRating, Money aCreditLimit)
  {
    super(aName, aAddress);
    contactName = aContactName;
    creditRating = aCreditRating;
    creditLimit = aCreditLimit;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Employee getSalesRep()
  {
    return salesRep;
  }

  public boolean hasSalesRep()
  {
    boolean has = salesRep != null;
    return has;
  }

  public boolean setSalesRep(Employee aNewSalesRep)
  {
    boolean wasSet = false;
    salesRep = aNewSalesRep;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    salesRep = null;
    super.delete();
  }


  /**
   * methods
   */
  // line 61 "hellouml.ump"
   public void billForMonth(int m){
    
  }

  // line 62 "hellouml.ump"
   public void remind(){
    
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "salesRep = "+(getSalesRep()!=null?Integer.toHexString(System.identityHashCode(getSalesRep())):"null")
     + outputString;
  }
}