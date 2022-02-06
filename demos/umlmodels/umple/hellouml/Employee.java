/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.util.*;

// line 67 "hellouml.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Associations
  private List<SalesRegion> territory;
  private List<Assigned> assigneds;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee()
  {
    territory = new ArrayList<SalesRegion>();
    assigneds = new ArrayList<Assigned>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public SalesRegion getTerritory(int index)
  {
    SalesRegion aTerritory = territory.get(index);
    return aTerritory;
  }

  public List<SalesRegion> getTerritory()
  {
    List<SalesRegion> newTerritory = Collections.unmodifiableList(territory);
    return newTerritory;
  }

  public int numberOfTerritory()
  {
    int number = territory.size();
    return number;
  }

  public boolean hasTerritory()
  {
    boolean has = territory.size() > 0;
    return has;
  }

  public int indexOfTerritory(SalesRegion aTerritory)
  {
    int index = territory.indexOf(aTerritory);
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

  public static int minimumNumberOfTerritory()
  {
    return 0;
  }

  public boolean addTerritory(SalesRegion aTerritory)
  {
    boolean wasAdded = false;
    if (territory.contains(aTerritory)) { return false; }
    territory.add(aTerritory);
    if (aTerritory.indexOfEmployee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTerritory.addEmployee(this);
      if (!wasAdded)
      {
        territory.remove(aTerritory);
      }
    }
    return wasAdded;
  }

  public boolean removeTerritory(SalesRegion aTerritory)
  {
    boolean wasRemoved = false;
    if (!territory.contains(aTerritory))
    {
      return wasRemoved;
    }

    int oldIndex = territory.indexOf(aTerritory);
    territory.remove(oldIndex);
    if (aTerritory.indexOfEmployee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTerritory.removeEmployee(this);
      if (!wasRemoved)
      {
        territory.add(oldIndex,aTerritory);
      }
    }
    return wasRemoved;
  }

  public boolean addTerritoryAt(SalesRegion aTerritory, int index)
  {  
    boolean wasAdded = false;
    if(addTerritory(aTerritory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTerritory()) { index = numberOfTerritory() - 1; }
      territory.remove(aTerritory);
      territory.add(index, aTerritory);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTerritoryAt(SalesRegion aTerritory, int index)
  {
    boolean wasAdded = false;
    if(territory.contains(aTerritory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTerritory()) { index = numberOfTerritory() - 1; }
      territory.remove(aTerritory);
      territory.add(index, aTerritory);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTerritoryAt(aTerritory, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAssigneds()
  {
    return 0;
  }

  public Assigned addAssigned(SalesRegion aSalesRegion)
  {
    return new Assigned(this, aSalesRegion);
  }

  public boolean addAssigned(Assigned aAssigned)
  {
    boolean wasAdded = false;
    if (assigneds.contains(aAssigned)) { return false; }
    Employee existingEmployee = aAssigned.getEmployee();
    boolean isNewEmployee = existingEmployee != null && !this.equals(existingEmployee);
    if (isNewEmployee)
    {
      aAssigned.setEmployee(this);
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
    //Unable to remove aAssigned, as it must always have a employee
    if (!this.equals(aAssigned.getEmployee()))
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
    ArrayList<SalesRegion> copyOfTerritory = new ArrayList<SalesRegion>(territory);
    territory.clear();
    for(SalesRegion aTerritory : copyOfTerritory)
    {
      aTerritory.removeEmployee(this);
    }
    for(int i=assigneds.size(); i > 0; i--)
    {
      Assigned aAssigned = assigneds.get(i - 1);
      aAssigned.delete();
    }
  }

}