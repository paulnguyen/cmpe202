
public interface IModel
{
    void attachObserver( IObserver o ) ;
    void detachObserver( IObserver o ) ;
    void notifyObservers() ;
    String getData() ;
}
