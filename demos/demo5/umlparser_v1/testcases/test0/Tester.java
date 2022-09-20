
public class Tester {

	private static boolean DEBUG = true ;  
	public String hello =  "Hello World!" ;

    public static void main(final String[] args)
    {
        Component obj = new ConcreteDecoratorB( new ConcreteDecoratorA( new ConcreteComponent() ) ) ;
        String result = obj.operation() ;
        System.out.println( result );
    }

    public void sayHello1(String msg) {
        String local1 = "" ;
        String local2 ;
        int    local3 ;
    	System.out.println( hello + msg ) ;
    }

    public void sayHello2(String msg) {
        int local1 = 100 ;
        int local2 ;
    }

}
