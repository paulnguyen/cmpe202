/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class MyCardsPayScreen implements AppScreen {

     private AppScreen cardsMainScreen ;

    public void touch(int x, int y)
    {
        AppController app = AppController.getInstance() ;
        if (x==3 && y ==3 )
            app.setScreen(cardsMainScreen);
        if (    ( x == 1 && y == 2 ) ||
                ( x == 2 && y == 2 ) ||
                ( x == 3 && y == 2 )
            )
        {
            Card currentCard = app.getCurrentCard() ;
            System.out.println( "Payment Processed for $1.50" ) ;
            currentCard.pay( 1.50f ) ;
        }
    }

    public void setcardsMainScreen( AppScreen scr )
    {
        this.cardsMainScreen = scr ;
    }

    public String display()
    {
        String returnVal = "Scan Now" ;
        System.out.println( returnVal ) ;
        return returnVal ;
    }

    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }

}

