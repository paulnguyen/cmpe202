/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

/*

Note: Alternative Implementation using an Abstract Class

public abstract class TouchEventHandler
{
    private TouchEventHandler next ;
    abstract void touch(int x, int y) ;
}

*/

public interface TouchEventHandler
{
    void touch(int x, int y) ;
    void setNext( TouchEventHandler next ) ;
}




