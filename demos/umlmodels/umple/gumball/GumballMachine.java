/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-bd20d13 modeling language!*/


import java.util.*;

// line 31 "gumball.ump"
public class GumballMachine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GumballMachine Attributes

  /**
   * attributes
   */
  private int count;

  //GumballMachine State Machines
  public enum State { NoQuarterState, HasQuarterState, SoldState, SoldOutState }
  private State state;

  //GumballMachine Associations
  private List<State> states;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GumballMachine(int aCount)
  {
    count = aCount;
    states = new ArrayList<State>();
    setState(State.NoQuarterState);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean insertQuarter()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case NoQuarterState:
        setState(State.HasQuarterState);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ejectQuarter()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case HasQuarterState:
        setState(State.NoQuarterState);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean turnCrank()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case HasQuarterState:
        setState(State.SoldState);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean dispense()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case SoldState:
        if (count>0)
        {
          setState(State.NoQuarterState);
          wasEventProcessed = true;
          break;
        }
        if (count<=0)
        {
          setState(State.SoldOutState);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;
  }

  public State getState(int index)
  {
    State aState = states.get(index);
    return aState;
  }

  /**
   * associations
   */
  public List<State> getStates()
  {
    List<State> newStates = Collections.unmodifiableList(states);
    return newStates;
  }

  public int numberOfStates()
  {
    int number = states.size();
    return number;
  }

  public boolean hasStates()
  {
    boolean has = states.size() > 0;
    return has;
  }

  public int indexOfState(State aState)
  {
    int index = states.indexOf(aState);
    return index;
  }

  public static int minimumNumberOfStates()
  {
    return 0;
  }

  public boolean addState(State aState)
  {
    boolean wasAdded = false;
    if (states.contains(aState)) { return false; }
    states.add(aState);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeState(State aState)
  {
    boolean wasRemoved = false;
    if (states.contains(aState))
    {
      states.remove(aState);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStateAt(State aState, int index)
  {  
    boolean wasAdded = false;
    if(addState(aState))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStates()) { index = numberOfStates() - 1; }
      states.remove(aState);
      states.add(index, aState);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateAt(State aState, int index)
  {
    boolean wasAdded = false;
    if(states.contains(aState))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStates()) { index = numberOfStates() - 1; }
      states.remove(aState);
      states.add(index, aState);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateAt(aState, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    states.clear();
  }


  /**
   * methods
   */
  // line 38 "gumball.ump"
   public void insertQuarter(){
    
  }

  // line 39 "gumball.ump"
   public void ejectQuarter(){
    
  }

  // line 40 "gumball.ump"
   public void turnCrank(){
    
  }

  // line 41 "gumball.ump"
   public void dispense(){
    
  }

  // line 42 "gumball.ump"
   protected void setState(State state){
    
  }

  // line 43 "gumball.ump"
   protected void releaseBall(){
    
  }

  // line 44 "gumball.ump"
   protected int getCount(){
    
  }

  // line 45 "gumball.ump"
   protected  refill(int count){
    
  }

  // line 46 "gumball.ump"
   public State getSoldOutState(){
    
  }

  // line 47 "gumball.ump"
   public State getNoQuarterState(){
    
  }

  // line 48 "gumball.ump"
   public State getHasQuarterState(){
    
  }

  // line 49 "gumball.ump"
   public State getSoldState(){
    
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}