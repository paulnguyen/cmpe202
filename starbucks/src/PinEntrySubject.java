/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public interface PinEntrySubject
{
    void registerObserver( PinEntryObserver obj ) ;
    void removeObserver( PinEntryObserver obj ) ;
    void notifyObservers( ) ;
    
}



