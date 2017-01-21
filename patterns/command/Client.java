package command;

public class Client {
    
    private String helloMessage = "Hello World!" ;
    private String goodbyeMessage = "Goodbye World!" ;
    private Menu appMenu = new Menu() ;
    
    public Menu getMenu() {
        return appMenu ;
    }
    
    public void runSetup() {
        MenuItem hello = new MenuItem() ;
        MenuItem goodbye = new MenuItem() ;
        Command sayHello = new ConcreteCommand();
        Command sayGoodbye = new ConcreteCommand();
        sayHello.setReceiver(
                new Receiver() {
                    public void doAction() {
                        System.out.println( helloMessage );    
                    }
                }
        );
        sayGoodbye.setReceiver(
                new Receiver() {
                    public void doAction() {
                        System.out.println( goodbyeMessage );
                    }
                }
        );
        hello.setCommand( sayHello );
        goodbye.setCommand( sayGoodbye );
        appMenu.addMenuItem(hello, "hello");
        appMenu.addMenuItem(goodbye, "goodbye");
    }
    
    
    public static void main( String [] args )
    {
        Client c = new Client() ;
        c.runSetup() ;
        Menu m = c.getMenu() ;
        m.selectMenuItem("hello") ;
        m.selectMenuItem("goodbye") ;
        m.selectMenuItem("n/a") ;
    }
        
 
}
 
