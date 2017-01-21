

public interface IKeyPadSubject
{
    void attach( IKeyPadObserver obj ) ;
    void removeObserver( IKeyPadObserver obj ) ;
    void notifyObservers() ;
}
