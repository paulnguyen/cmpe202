/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public interface PinState
{
    void backspace() ;
    void number( String digit ) ;
    void validPin() ;
    void invalidPin() ;

}
