/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class AppController implements AppScreen, MenuBar {

    private static AppController theController = null;
    private AppScreen current;
    private Pin thePin;
    private Card currentCard;

    /* screens */
    private MyCardsMainScreen cardsMainScreen = new MyCardsMainScreen();
    private MyCardsPayScreen payScreen = new MyCardsPayScreen();
    private MyCardsOptionsScreen cardOptionsScreen = new MyCardsOptionsScreen();
    private RewardScreen rewardScreen = new RewardScreen();
    private CardsMoreOptionsScreen cardMoreOptionsScreen = new CardsMoreOptionsScreen();
    private FindStarbuckScreen findStarbucksScreen = new FindStarbuckScreen();
    private PaymentScreen paymentScreen = new PaymentScreen();
    private PinScreen pinScreen = new PinScreen();
    private SettingScreen settingScreen = new SettingScreen();
    private AddCardScreen addCardScreen = new AddCardScreen();

    private void configScreens()
    {
        this.cardsMainScreen.setOptionsScreen(this.cardOptionsScreen);
        this.cardsMainScreen.setPayScreen(this.payScreen);
        this.payScreen.setcardsMainScreen(this.cardsMainScreen);
        this.cardOptionsScreen.setMoreOptionsScreen(this.cardMoreOptionsScreen);
        this.settingScreen.setAddCardScreen(this.addCardScreen);
        this.addCardScreen.setCardsMainScreen(this.cardsMainScreen);
        this.addCardScreen.setSettingsScreen(this.settingScreen);
    }

    /* commands */
    private MenuCommand slot1 = new MenuCommand(cardsMainScreen);
    private MenuCommand slot2 = new MenuCommand(paymentScreen);
    private MenuCommand slot3 = new MenuCommand(rewardScreen);
    private MenuCommand slot4 = new MenuCommand(findStarbucksScreen);
    private MenuCommand slot5 = new MenuCommand(settingScreen);

    private AppController()
    {
    }

    public static AppController getInstance() {
        if (theController == null) {
            theController = new AppController();
            theController.startUp();
            return theController;
        }
        else
            return theController;
    }

    public void startUp() {
        this.current = this.pinScreen;
        this.thePin = Pin.getInstance();
        this.currentCard = new Card();
        configScreens() ;
    }

    public Card getCurrentCard() {
        return this.currentCard;
    }

    public void setCurrentCard(Card newCard) {
        this.currentCard = newCard;
    }

    public void touch(int x, int y) {
        current.touch(x, y);
        if ( thePin.isAuthenticated() &&  isCurrentScreenPinScreen() )
            setScreen(cardsMainScreen);
    }

    public String display() {
        System.out.println(current.getClass().getName());
        current.display();
        return "";
    }

    public void setScreen(AppScreen screen) {
        this.current = screen;
        display();
    }
    
    public String getCurrentScreenName()
    {
        return current.getClass().getName() ;
    }

    private boolean isCurrentScreenPinScreen() {
        return current.getClass().getName().equals("PinScreen");
    }

    public void topLeftCmd() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            this.current.topLeftCmd();
    }

    public void topRightCmd() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            this.current.topRightCmd();
    }

    public void menu1() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            slot1.execute();
    }

    public void menu2() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            slot2.execute();
    }

    public void menu3() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            slot3.execute();
    }

    public void menu4() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            slot4.execute();
    }

    public void menu5() {
        if (!thePin.isAuthenticated())
            /* do nothing */ ;
        else
            slot5.execute();
    }
}

