/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class SettingScreen implements AppScreen
{
    private AppScreen addCardScreen ;

    public void setAddCardScreen( AppScreen scr )
    {
        this.addCardScreen = scr ;
    }

    public SettingScreen()
    {
    }

    public void touch(int x, int y) {
        AppController app = AppController.getInstance() ;
        if (    ( x == 1 && y == 2 ) ||
                ( x == 2 && y == 2 ) ||
                ( x == 3 && y == 2 )
            )
            app.setScreen(addCardScreen);
    }

    public String display()
    {
        String returnVal = "Manage Card, Billing, Passcode.  Show About & Terms" ;
        System.out.println( returnVal ) ;
        return returnVal ;
    }

    public void topLeftCmd() {
        
    }

    public void topRightCmd() {
        
    }

}
