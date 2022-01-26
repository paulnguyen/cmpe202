
public class Main {
    public static void main(String[] args) {
		AppAuthProxy app = new AppAuthProxy() ;
		app.display() ;
		app.touch(1,5) ;
		app.touch(2,5) ;
		app.touch(3,5) ;
		app.touch(1,6) ;
		app.display() ;
		app.execute("A") ;
		app.display() ;
		app.landscape() ;
		app.display() ;
    }
}
