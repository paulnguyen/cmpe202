/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class CardsMoreOptionsScreen implements AppScreen {

    public void touch(int x, int y) {

    }

    public String display()
    {
        String retval = "Refresh, Reload or View Recent Transactions" ;
        System.out.println( retval ) ;
        return retval ;
    }

    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }

}
