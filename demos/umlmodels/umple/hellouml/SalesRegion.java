/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.util.*;

// line 72 "hellouml.ump"
public class SalesRegion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SalesRegion Associations
  private List<Employee> employees;
  private List<Assigned> assigneds;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SalesRegion()
  {
    employees = new ArrayList<Employee>();
    assigneds = new ArrayList<Assigned>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Employee getEmployee(int index)
  {
    Employee aEmployee = employees.get(index);
    return aEmployee;
  }

  public List<Employee> getEmployees()
  {
    List<Employee> newEmployees = Collections.unmodifiableList(employees);
    return newEmployees;
  }

  public int numberOfEmployees()
  {
    int number = employees.size();
    return number;
  }

  public boolean hasEmployees()
  {
    boolean has = employees.size() > 0;
    return has;
  }

  public int indexOfEmployee(Employee aEmployee)
  {
    int index = employees.indexOf(aEmployee);
    return index;
  }

  public Assigned getAssigned(int index)
  {
    Assigned aAssigned = assigneds.get(index);
    return aAssigned;
  }

  public List<Assigned> getAssigneds()
  {
    List<Assigned> newAssigneds = Collections.unmodifiableList(assigneds);
    return newAssigneds;
  }

  public int numberOfAssigneds()
  {
    int number = assigneds.size();
    return number;
  }

  public boolean hasAssigneds()
  {
    boolean has = assigneds.size() > 0;
    return has;
  }

  public int indexOfAssigned(Assigned aAssigned)
  {
    int index = assigneds.indexOf(aAssigned);
    return index;
  }

  public static int minimumNumberOfEmployees()
  {
    return 0;
  }

  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    employees.add(aEmployee);
    if (aEmployee.indexOfTerritory(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmployee.addTerritory(this);
      if (!wasAdded)
      {
        employees.remove(aEmployee);
      }
    }
    return wasAdded;
  }

  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    if (!employees.contains(aEmployee))
    {
      return wasRemoved;
    }

    int oldIndex = employees.indexOf(aEmployee);
    employees.remove(oldIndex);
    if (aEmployee.indexOfTerritory(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmployee.removeTerritory(this);
      if (!wasRemoved)
      {
        employees.add(oldIndex,aEmployee);
      }
    }
    return wasRemoved;
  }

  public boolean addEmployeeAt(Employee aEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addEmployee(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
  {
    boolean wasAdded = false;
    if(employees.contains(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeAt(aEmployee, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAssigneds()
  {
    return 0;
  }

  public Assigned addAssigned(Employee aEmployee)
  {
    return new Assigned(aEmployee, this);
  }

  public boolean addAssigned(Assigned aAssigned)
  {
    boolean wasAdded = false;
    if (assigneds.contains(aAssigned)) { return false; }
    SalesRegion existingSalesRegion = aAssigned.getSalesRegion();
    boolean isNewSalesRegion = existingSalesRegion != null && !this.equals(existingSalesRegion);
    if (isNewSalesRegion)
    {
      aAssigned.setSalesRegion(this);
    }
    else
    {
      assigneds.add(aAssigned);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssigned(Assigned aAssigned)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssigned, as it must always have a salesRegion
    if (!this.equals(aAssigned.getSalesRegion()))
    {
      assigneds.remove(aAssigned);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssignedAt(Assigned aAssigned, int index)
  {  
    boolean wasAdded = false;
    if(addAssigned(aAssigned))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssigneds()) { index = numberOfAssigneds() - 1; }
      assigneds.remove(aAssigned);
      assigneds.add(index, aAssigned);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignedAt(Assigned aAssigned, int index)
  {
    boolean wasAdded = false;
    if(assigneds.contains(aAssigned))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssigneds()) { index = numberOfAssigneds() - 1; }
      assigneds.remove(aAssigned);
      assigneds.add(index, aAssigned);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignedAt(aAssigned, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Employee> copyOfEmployees = new ArrayList<Employee>(employees);
    employees.clear();
    for(Employee aEmployee : copyOfEmployees)
    {
      aEmployee.removeTerritory(this);
    }
    for(int i=assigneds.size(); i > 0; i--)
    {
      Assigned aAssigned = assigneds.get(i - 1);
      aAssigned.delete();
    }
  }

}