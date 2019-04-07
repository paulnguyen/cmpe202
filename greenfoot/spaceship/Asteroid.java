import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Asteroid that flies across the screen.
 */
public class Asteroid  extends Actor
{
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int xpos = getX() + 1;
        if (xpos >= getWorld().getWidth()) {
            getWorld().removeObject(this);
        }
        else {
            setLocation(xpos, getY());
        }
    }    
}
