package decorator;

public class Tester {

    public static void runTest()
    {
        Component obj = new ConcreteDecoratorB( new ConcreteDecoratorA( new ConcreteComponent() ) ) ;
        String result = obj.operation() ;
        System.out.println( result );
    }
}
