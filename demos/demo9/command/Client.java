
public class Client {
    
    private String helloMessage = "Hello!" ;
    private Menu appMenu = new Menu() ;
    
    public Menu getMenu() {
        return appMenu ;
    }
    
    public void runSetup() {
        String helloMessage = "Ciao!" ;
        MenuItem hello = new MenuItem() ;
        Command sayHello = new ConcreteCommand();
        sayHello.setReceiver(
                new Receiver() {
                    public void doAction() {
                        System.out.println( helloMessage );    
                    }
                }
        );
        hello.setCommand( sayHello );
        appMenu.addMenuItem(hello, "hello");
    }
    
    public static void main( String [] args )
    {
        String helloMessage = "Bonjour!" ;
        Client c = new Client() ;
        c.runSetup() ;
        Menu m = c.getMenu() ;
        m.selectMenuItem("hello") ;
    }
        
 
}
 
