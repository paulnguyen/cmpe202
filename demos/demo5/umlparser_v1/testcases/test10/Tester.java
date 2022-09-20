
public class Tester {

    public static void main(String[] args)
    {
        Component obj = new DecoratorImplZ( new DecoratorImplY( new ComponentImplZ("Be yourself.") ) ) ;
        String result = obj.op() ;
        System.out.println( result );
    }
}
