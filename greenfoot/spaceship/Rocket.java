import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Space ship which shoots at asteroids.
 * 
 * @author Davin McCall
 */
public class Rocket  extends Actor
{
    private int shotTimer = 0;

    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (shotTimer > 0) {
            shotTimer = shotTimer - 1;
        }
        else if (Greenfoot.isKeyDown("space")) {
            getWorld().addObject(new Shot(this), getX(), getY());
            shotTimer = 200; // delay next shot
        }
    }

}
