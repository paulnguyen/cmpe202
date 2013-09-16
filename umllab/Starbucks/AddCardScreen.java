/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class AddCardScreen implements AppScreen
{
    private AppScreen settingsScreen ;
    private AppScreen cardsMainScreen ;

    public void setSettingsScreen( AppScreen scr )
    {
        this.settingsScreen = scr ;
    }

    public void setCardsMainScreen( AppScreen src )
    {
        this.cardsMainScreen = src ;
    }

    private enum Focus { NONE, CARD_ID, CARD_CODE }

    AddCardKeyPadAdapter kp ;
    StringBuffer cardId ;
    StringBuffer cardCode ;
    Focus  keyFocus = Focus.NONE ;
    String lastKey ;

    public AddCardScreen()
    {
        kp = new AddCardKeyPadAdapter(this) ;
        cardId = new StringBuffer() ;
        cardCode = new StringBuffer() ;
    }

    public void newKey( String key )
    {
        System.out.print( "New Key: " + key );
    }

    public void removeLastKey()
    {
        System.out.print("Remove Last Key");
    }

    public void keyPressed(String key)
    {
        this.lastKey = key ;
    }

    public void touch(int x, int y)
    {
        if (    (x == 1 && y == 3) ||
                (x == 2 && y == 3) ||
                (x == 3 && y == 3)
            )
        {
            System.out.println( "Focus Set on Card ID");
            this.keyFocus = Focus.CARD_ID ;
        }
        else if ( x == 2 && y == 4 )
        {
            System.out.println( "Focus Set on Card Code");
            this.keyFocus = Focus.CARD_CODE ;
        }
        else
        {
            this.lastKey = null ;
            this.kp.touch(x, y) ;
            if ( lastKey != null )
            {
                switch ( keyFocus )
                {
                    case CARD_ID: cardId.append(lastKey); break ;
                    case CARD_CODE: cardCode.append(lastKey) ; break ;
                    default: /* do nothing */ ;
                }
            }
            System.out.println( "Card ID: " + cardId.toString() ) ;
            System.out.println( "Card Code: " + cardCode.toString() ) ;
        }
    }

    public String display()
    {
        String returnVal = "Enter a new Card" ;
        System.out.println( returnVal ) ;
        return returnVal ;
    }

    public void topLeftCmd()
    {
        AppController app = AppController.getInstance() ;
        app.setScreen(this.settingsScreen);
    }

    public void topRightCmd()
    {
        AppController app = AppController.getInstance() ;
        // add new card
        Card newCard = new Card( cardId.toString(), cardCode.toString() ) ;
        // set current card
        app.setCurrentCard( newCard ) ;
        // go back to pay screen
        app.setScreen(this.cardsMainScreen);
    }
}
