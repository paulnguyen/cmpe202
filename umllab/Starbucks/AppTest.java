/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class AppTest
{

    public static void main ( String[] args )
    {
        test5();
    }

    public static void test1()
    {
        App app = new App() ;
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
    }
    
    public static void test2()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to cards main screen
        app.menu1();
        // switch to payments setup screen
        app.menu2();
        // switch to rewards screen
        app.menu3();
        // switch to find starbucks screen
        app.menu4();
        // switch to settings screen
        app.menu5();
    }
    
    public static void test3()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        // switch to pay screen
        app.touch(3, 3);
    }

    public static void test4()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        // switch to options screen
        app.touch(2, 4);
    }

    public static void test5()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        // switch to pay screen
        app.touch(3, 3);
        // switch back to cards main
        app.touch(3, 3);
    }

    public static void test6()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to options screen
        app.touch(2, 4);
        // switch to more options screen
        app.touch(2, 7);
    }

    public static void test7()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to settings screen
        app.menu5();
        // switch to add card screen
        app.touch(1, 2);
        // cancel out back to settings screen
        app.topLeftCmd();
        // display current screen
        app.display() ;
    }

    public static void test8()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to settings screen
        app.menu5();
        // switch to add card screen
        app.touch(1, 2);
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(1, 5); 
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        // set focus on card code
        app.touch(2, 4);
        // enter 8-digit card code
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(2, 6);        
        app.touch(3, 6);        
        app.touch(1, 7);        
        app.touch(2, 7);        
        // set focus on card code
        app.touch(2, 4);
        // enter 8-digit card code
        app.touch(2, 6);        
        app.touch(3, 6);        
        app.touch(1, 7);        
        app.touch(2, 7);        
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(1, 5); 
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);        
        app.touch(2, 6);        
        app.touch(3, 6);        
        app.touch(1, 7);        
        app.touch(2, 7);        
        // add the card
        app.topRightCmd() ;
        // display current screen
        app.display() ;
    }

    public static void test9()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to pay screen
        app.touch(3, 3);
        // pay twice
        app.touch( 1, 2 ) ;
        app.touch( 2, 2 ) ;
        // go back to main pay screen
        app.touch( 3, 3 ) ;
        // display current screen
        app.display() ;
    }

    public static void test10()
    {
        App app = new App() ;
        // pin auth
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // switch to pay screen
        app.touch(3, 3);
        // pay twice
        app.touch( 1, 2 ) ;
        app.touch( 2, 2 ) ;
        // go back to main pay screen
        app.touch( 3, 3 ) ;
        // display current screen
        app.display() ;
        // switch to settings screen
        app.menu5();
        // switch to add card screen
        app.touch(1, 2);
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card code
        app.touch(2, 4);
        // enter 8-digit card code
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card code
        app.touch(2, 4);
        // enter 8-digit card code
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // set focus on card id
        app.touch(2, 3);
        // enter 16-digit card id
        app.touch(1, 5);
        app.touch(2, 5);
        app.touch(3, 5);
        app.touch(1, 6);
        app.touch(2, 6);
        app.touch(3, 6);
        app.touch(1, 7);
        app.touch(2, 7);
        // add the card
        app.topRightCmd() ;
        // display current screen
        app.display() ;
        // switch to pay screen
        app.touch(3, 3);
        // pay once
        app.touch( 3, 2 ) ;
        // go back to main pay screen
        app.touch( 3, 3 ) ;
        // display current screen
        app.display() ;
    }

}

