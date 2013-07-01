import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{

    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }

    public void act() 
    {
        int mouseX, mouseY ;

        if(Greenfoot.mousePressed(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            System.out.println( "Clicked!" ) ;
            GreenfootImage gi;
            gi = new GreenfootImage(100,100);
            gi.setColor( java.awt.Color.YELLOW ) ;
            gi.fill() ;
            gi.setColor( java.awt.Color.BLACK ) ;
            gi.drawString( "Crank Turned!", 0, 50 );
            Message m = new Message() ;
            m.setImage(gi);
            World world = getWorld();
            world.addObject( m, mouseX, mouseY ) ;
        }

        Actor coin;
        coin = getOneIntersectingObject( Coin.class ) ;
        if ( coin != null )
        {
            System.out.println( coin.toString() ) ;
            World world = getWorld() ;
            world.removeObject( coin ) ;
        }
    }    
}
