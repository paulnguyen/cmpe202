/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class FindStarbuckScreen implements AppScreen {

    public void touch(int x, int y) {

    }

    public String display()
    {
        String retval = "Google Map of Local Starbucks" ;
        System.out.println( retval ) ;
        return retval ;
    }

    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }

}
