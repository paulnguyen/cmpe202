/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class MasterTester {

    public static void main ( String[] args )
    {
        MasterTester app = new MasterTester() ;

        // pin auth
        System.out.println( "==> pin auth <==" ) ;
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        System.out.println( "==> pin auth <== (Card Bal = $16.50)" ) ;
        System.out.println( "" ) ;

        // switch to pay screen
        System.out.println( "==> switch to pay screen <==" ) ;
        app.touch(3, 3);
        System.out.println( "==> switch to pay screen <== (Scan Now)" ) ;
        System.out.println( "" ) ;

        // switch to settings screen
        System.out.println( "==> switch to settings screen <==" ) ;
        app.menu5();
        System.out.println( "==> switch to settings screen <== (Manage Card, Billing, Passcode.  Show About & Terms)" ) ;
        System.out.println( "" ) ;

        // switch to add card screen
        System.out.println( "==> switch to add card screen <==" ) ;       
        app.touch(1, 2);
        System.out.println( "==> switch to add card screen <== (Enter a new Card)" ) ;
        System.out.println( "" ) ;

        // set focus on card id
        System.out.println( "==> set focus on card id <==" ) ;       
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;      
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card code
        System.out.println( "==> set focus on card code <==" ) ;              
        app.touch(2, 4);
        // enter 8-digit card code
        System.out.println( "==> enter 4 digits for card code <==" ) ;      
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;              
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;              
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card code
        System.out.println( "==> set focus on card code <==" ) ;              
        app.touch(2, 4);
        // enter 8-digit card code
        System.out.println( "==> enter 4 digits for card code <==" ) ;              
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card id
        System.out.println( "==> set focus on card id <==" ) ;              
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 8 digits for card id <==" ) ;              
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // add the card
        System.out.println( "==> add new card <==" ) ;              
        app.topRightCmd() ;
        System.out.println( " " ) ;

        // switch to main payment screen
        System.out.println( "==> switch to main screen <==" ) ;
        app.menu1();
        System.out.println( "==> switch to main screen <==" ) ;
        System.out.println( " " ) ;  

        // switch to pay screen
        System.out.println( "==> switch to pay screen <==" ) ;              
        app.touch(3, 3);
        System.out.println( "==> switch to pay screen <== (Scan Now)" ) ;              
        System.out.println( " " ) ;                      

        // pay twice
        System.out.println( "==> pay twice <==" ) ;
        app.touch( 1, 2 ) ;
        app.touch( 2, 2 ) ;
        System.out.println( "==> pay twice <==" ) ;
        System.out.println( "" ) ;

        // go back to main pay screen
        System.out.println( "==> go back to main screen <==" ) ;
        app.touch( 3, 3 ) ;
        System.out.println( "==> go back to main screen <== (Card Bal = $13.50)" ) ;
        System.out.println( "" ) ;

        // display current screen
        System.out.println( "==> display current screen <==" ) ;
        app.display() ;
        System.out.println( "==> display current screen <==" ) ;
        System.out.println( "" ) ;

        // switch to settings screen
        System.out.println( "==> switch to settings screen <==" ) ;
        app.menu5();
        System.out.println( "==> switch to settings screen <== (Manage Card, Billing, Passcode.  Show About & Terms)" ) ;
        System.out.println( "" ) ;

        // switch to add card screen
        System.out.println( "==> switch to add card screen <==" ) ;       
        app.touch(1, 2);
        System.out.println( "==> switch to add card screen <== (Enter a new Card)" ) ;
        System.out.println( "" ) ;

        // set focus on card id
        System.out.println( "==> set focus on card id <==" ) ;       
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;      
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card code
        System.out.println( "==> set focus on card code <==" ) ;              
        app.touch(2, 4);
        // enter 8-digit card code
        System.out.println( "==> enter 4 digits for card code <==" ) ;      
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;              
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 4 digits for card id <==" ) ;              
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card code
        System.out.println( "==> set focus on card code <==" ) ;              
        app.touch(2, 4);
        // enter 8-digit card code
        System.out.println( "==> enter 4 digits for card code <==" ) ;              
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card id
        System.out.println( "==> set focus on card id <==" ) ;              
        app.touch(2, 3);
        // enter 16-digit card id
        System.out.println( "==> enter 8 digits for card id <==" ) ;              
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // add the card
        System.out.println( "==> add new card <==" ) ;              
        app.topRightCmd() ;
        System.out.println( " " ) ;  

        // switch to main payment screen
        System.out.println( "==> switch to main screen <==" ) ;
        app.menu1();
        System.out.println( "==> switch to main screen <==" ) ;
        System.out.println( " " ) ;  

        // switch to pay screen
        System.out.println( "==> switch to pay screen <==" ) ;              
        app.touch(3, 3);
        System.out.println( "==> switch to pay screen <== (Scan Now)" ) ;              
        System.out.println( " " ) ;                      

        // pay once
        System.out.println( "==> make one payment <==" ) ;              
        app.touch( 3, 2 ) ;
        System.out.println( "==> make one payment <==" ) ;              
        System.out.println( " " ) ;              

        // go back to main pay screen
        System.out.println( "==> go back to main pay screen <==" ) ;              
        app.touch( 3, 3 ) ;
        System.out.println( "==> go back to main pay screen <== (Card Bal: $15.00)" ) ;              
        System.out.println( " " ) ;              

        // display current screen
        System.out.println( "==> display current screen <==" ) ;              
        app.display() ;
        System.out.println( "==> display current screen <==" ) ;              
        System.out.println( " " ) ;              

    }


    private AppController appController ;

    public MasterTester() {
        appController = AppController.getInstance() ;
        appController.startUp() ;
    }

    public void touch(int x, int y) {
        appController.touch( x, y ) ; 
    }

    public void display()
    {
        appController.display() ;
        System.out.println( onScreen() ) ;
    }

    public String onScreen() {
        return appController.display() ;
    }

    public void topLeftCmd() {
        appController.topLeftCmd() ;
    }

    public void topRightCmd() {
        appController.topRightCmd() ;
    }

    public void menu1() {
        appController.menu1() ;
    }

    public void menu2() {
        appController.menu2() ;
    }

    public void menu3() {
        appController.menu3() ;
    }

    public void menu4() {
        appController.menu4() ;
    }   

    public void menu5() {
        appController.menu5() ;
    }
}

