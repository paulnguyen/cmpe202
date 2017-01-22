
/**
 * Write a description of interface ITouchEventHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ITouchEventHandler
{

    void touch(int x, int y);
    void setNext( ITouchEventHandler next) ;
}
