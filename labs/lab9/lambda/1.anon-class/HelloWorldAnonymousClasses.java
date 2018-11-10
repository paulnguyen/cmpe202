
/*

	https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html

	Like local classes, anonymous classes can capture variables; they have the 
	same access to local variables of the enclosing scope:
	An anonymous class has access to the members of its enclosing class.
    An anonymous class cannot access local variables in its enclosing scope 
    that are not declared as final or effectively final.

    Like a nested class, a declaration of a type (such as a variable) in an 
    anonymous class shadows any other declarations in the enclosing scope that 
    have the same name. See Shadowing for more information.

	Anonymous classes also have the same restrictions as local classes with 
	respect to their members:

    You cannot declare static initializers or member interfaces in an 
    anonymous class.

   	An anonymous class can have static members provided that they 
   	are constant variables.

	Note that you can declare the following in anonymous classes:

    Fields
    Extra methods (even if they do not implement any methods of the supertype)
    Instance initializers
    Local classes

	However, you cannot declare constructors in an anonymous class.


*/


public class HelloWorldAnonymousClasses {
  
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
  
    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
      
        HelloWorld englishGreeting = new EnglishGreeting();
        
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
        
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses myApp =
            new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }            
}