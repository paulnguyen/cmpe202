

public class HelloJavaClosure {

	//private String message = "Hello World" ;
  
    interface HelloWorld {
        public void greet();
    }
  
    public HelloWorld sayHello() {
        
       return new HelloWorld() {
            String message = "Hello World" ;
            public void greet() {
                System.out.println( message );
            }
        };        
    }

    public static void main(String[] args) {
        String message = "Tout Le Monde";
        HelloJavaClosure myApp = new HelloJavaClosure();
        myApp.sayHello().greet() ;
    }            
}