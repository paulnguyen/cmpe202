import java.util.ArrayList;

public class Model implements IModel
{
    private Data coreData ;
    private ArrayList<IObserver> observers ;
    
    public Model()
    {
        coreData = new Data() ;
        observers = new ArrayList<IObserver>() ;
    }
    
    public void attachObserver( IObserver o ) 
    { 
         observers.add( o ) ;
    }
    
    public void detachObserver( IObserver o ) 
    { 
        int i = observers.indexOf(o) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }
    
    public void notifyObservers() 
    { 
        for (int i=0; i<observers.size(); i++)
        {
            IObserver observer = observers.get(i) ;
            observer.update( ) ;
        }    
    }
    
    public void setData( String msg )
    {
        coreData.setMessage( msg ) ;
        notifyObservers() ;
    }
    
    public String getData() 
    { 
        return coreData.getMessage() ; 
    }    
    
}
