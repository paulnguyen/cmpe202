/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class PaymentScreen implements AppScreen {

    public void touch(int x, int y) {

    }

    public String display()
    {
        String message = "Enable Payments?" ;
        System.out.println( message ) ;
        return message ;
    }

    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }

}



