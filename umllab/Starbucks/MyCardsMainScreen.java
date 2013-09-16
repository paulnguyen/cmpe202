/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class MyCardsMainScreen implements AppScreen {

    private AppScreen payScreen ;
    private AppScreen optionsScreen ;

    public MyCardsMainScreen()
    {
    }

    public void setPayScreen( AppScreen scr )
    {
        this.payScreen = scr ;
    }

    public void setOptionsScreen( AppScreen src )
    {
        this.optionsScreen = src ;
    }

    public void touch(int x, int y)
    {
        AppController app = AppController.getInstance() ;
        if ( x == 3 && y == 3 )
            app.setScreen(payScreen) ;
        else if ( x == 2 && y == 4 )
            app.setScreen(optionsScreen) ;
    }

    public String display()
    {
        AppController app = AppController.getInstance() ;
        Card card = app.getCurrentCard() ;
        String returnVal = "Card Balance: " + card.getBalance() ;
        card.display() ;
        return returnVal ;
    }

    public void topLeftCmd()
    {
    }

    public void topRightCmd()
    {
    }


}

