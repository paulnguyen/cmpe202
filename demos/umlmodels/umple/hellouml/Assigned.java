/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/



// line 76 "hellouml.ump"
public class Assigned
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Assigned Associations
  private Employee employee;
  private SalesRegion salesRegion;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetEmployee;
  private boolean canSetSalesRegion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Assigned(Employee aEmployee, SalesRegion aSalesRegion)
  {
    cachedHashCode = -1;
    canSetEmployee = true;
    canSetSalesRegion = true;
    boolean didAddEmployee = setEmployee(aEmployee);
    if (!didAddEmployee)
    {
      throw new RuntimeException("Unable to create assigned due to employee");
    }
    boolean didAddSalesRegion = setSalesRegion(aSalesRegion);
    if (!didAddSalesRegion)
    {
      throw new RuntimeException("Unable to create assigned due to salesRegion");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Employee getEmployee()
  {
    return employee;
  }

  public SalesRegion getSalesRegion()
  {
    return salesRegion;
  }

  public boolean setEmployee(Employee aEmployee)
  {
    boolean wasSet = false;
    if (!canSetEmployee) { return false; }
    if (aEmployee == null)
    {
      return wasSet;
    }

    Employee existingEmployee = employee;
    employee = aEmployee;
    if (existingEmployee != null && !existingEmployee.equals(aEmployee))
    {
      existingEmployee.removeAssigned(this);
    }
    if (!employee.addAssigned(this))
    {
      employee = existingEmployee;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setSalesRegion(SalesRegion aSalesRegion)
  {
    boolean wasSet = false;
    if (!canSetSalesRegion) { return false; }
    if (aSalesRegion == null)
    {
      return wasSet;
    }

    SalesRegion existingSalesRegion = salesRegion;
    salesRegion = aSalesRegion;
    if (existingSalesRegion != null && !existingSalesRegion.equals(aSalesRegion))
    {
      existingSalesRegion.removeAssigned(this);
    }
    if (!salesRegion.addAssigned(this))
    {
      salesRegion = existingSalesRegion;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Assigned compareTo = (Assigned)obj;
  
    if (employee == null && compareTo.employee != null)
    {
      return false;
    }
    else if (employee != null && !employee.equals(compareTo.employee))
    {
      return false;
    }

    if (salesRegion == null && compareTo.salesRegion != null)
    {
      return false;
    }
    else if (salesRegion != null && !salesRegion.equals(compareTo.salesRegion))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (employee != null)
    {
      cachedHashCode = cachedHashCode * 23 + employee.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (salesRegion != null)
    {
      cachedHashCode = cachedHashCode * 23 + salesRegion.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetEmployee = false;
    canSetSalesRegion = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Employee placeholderEmployee = employee;
    this.employee = null;
    placeholderEmployee.removeAssigned(this);
    SalesRegion placeholderSalesRegion = salesRegion;
    this.salesRegion = null;
    placeholderSalesRegion.removeAssigned(this);
  }

}