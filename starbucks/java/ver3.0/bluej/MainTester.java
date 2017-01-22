
public class MainTester
{
  
    public static void runTest()
    {
        Frame helloApp = new Frame( "Hello World App" ) ;
        ExitCommand exit = new ExitCommand() ;
        helloApp.setButton( exit ) ;
        helloApp.enterInput( "MVC Example" ) ;
        helloApp.display() ;
        helloApp.buttonClick() ;
    }
}
