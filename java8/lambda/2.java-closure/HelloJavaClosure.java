

public class HelloJavaClosure {

    // Class Instance Variable
	private String message = "Hello World" ;
  
    interface HelloWorld {
        public void greet();
    }
  
    public HelloWorld sayHello() {
       String message = "Tout Le Monde" ; 
       return new HelloWorld() {
            // Annnonymous Inner Class has access to Instance Variable
            public void greet() {
                System.out.println( message );
            }
        };        
    }

    public static void main(String[] args) {

        HelloJavaClosure myApp = new HelloJavaClosure();

        // Which "message" will be printed?
        HelloWorld h = myApp.sayHello() ;
        h.greet() ;
        
    }            
}