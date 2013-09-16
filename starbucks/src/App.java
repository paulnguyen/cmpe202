/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class App {
    private AppController appController ;

    public App() {
        appController = AppController.getInstance() ;
        appController.startUp() ;
    }

    public void touch(int x, int y) {
        appController.touch( x, y ) ; 
    }

    public void display()
    {
        appController.display() ;
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

