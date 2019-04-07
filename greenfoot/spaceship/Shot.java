import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bullet to be shot at asteroids.
 * 
 * The Shot moves to the top of the screen and then expires. If it hits an asteroid
 * on the way, it destroys the asteroid, and then expires immediately.
 */
public class Shot  extends Actor
{
    private Rocket myShip;

    /**
     * Constructor for a Shot. You must specify the ship the shot comes from.
     */
    public Shot(Rocket myShip)
    {
        this.myShip = myShip;
    }

    /**
     * Act - do whatever the Shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int ypos = getY();
        if (ypos > 0) {
            ypos = ypos - 5;
            setLocation(getX(), ypos);
            Actor rock = getOneIntersectingObject(Asteroid.class);
            if (rock != null) {
                // We've hit an asteroid!
                hitAnAsteroid();
                getWorld().removeObject(rock);
                getWorld().removeObject(this);
            }
        }
        else {
            // I reached the top of the screen
            getWorld().removeObject(this);
        }
    }
    
    /**
     * This method gets called (from the act method, above) when the shot hits an
     * asteroid. It needs to do only one thing: increase the score counter.
     * (Everything else, such as removing the asteroid which was hit, is dealt
     * with in the act method).
     */
    private void hitAnAsteroid()
    {
        // What goes here????
        // We want to call the "bumpCount" method from the Counter class -
        // but how??!!
    }
}
