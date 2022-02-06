/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.util.*;

// line 87 "hellouml.ump"
public class PersonalCustomer extends Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PersonalCustomer Attributes

  /**
   * attributes
   */
  private String creditCardNumber;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PersonalCustomer(String aName, Address aAddress, String aCreditCardNumber)
  {
    super(aName, aAddress);
    creditCardNumber = aCreditCardNumber;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}