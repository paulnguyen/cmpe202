/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class MyCardsOptionsScreen implements AppScreen {

    private AppScreen moreOptionsScreen ;

    public void setMoreOptionsScreen( AppScreen scr )
    {
        this.moreOptionsScreen = scr ;
    }

	public void touch(int x, int y)
    {
	    AppController app = AppController.getInstance() ;
        if (    (x == 1 && y == 7) ||
                (x == 2 && y == 7) ||
                (x == 3 && y == 7)
            )
            app.setScreen(moreOptionsScreen);
	}
	
	public String display()
    {
        String returnVal = "Reload, Refresh Balance or More Options?" ;
        System.out.println( returnVal ) ;
        return returnVal ;
    }
    
    public void topLeftCmd() {
    }

    public void topRightCmd() {
    }
     
}
