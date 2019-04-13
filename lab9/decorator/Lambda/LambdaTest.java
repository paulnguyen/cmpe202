public class LambdaTest{
    public static void runTest()
    {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        Component concreteDecorA = () -> "<em>" + concreteComponent.operation() + "</em>";
        Component concreteDecorB = () -> "<h1>" + concreteDecorA.operation() + "</h1>";

        String result = concreteDecorB.operation() ;
        System.out.println( result );
    }

    public static void main( String [] args )
    {
        LambdaTest t = new LambdaTest() ;
        t.runTest() ;
    }
}