
public class DecoratorImplY extends Decorator {

    private String addedState;

    public DecoratorImplY( Component c )
    {
        super( c ) ;
    }

    public String op()
    {
        addedState = super.op() ;
        return addedBehavior( addedState ) ;
    }

    private String addedBehavior(String in) {
        return "<h1>" + addedState + "</h1>" ;
    }

}
