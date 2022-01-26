
public interface IPinAuthSubject
{

    void registerObserver( IPinAuthObserver obj ) ;
    void removeObserver( IPinAuthObserver obj ) ;
    void notifyObserver( ) ;
    
}
