
public class DecoratorImplX extends Decorator {

    private String addedState;

    public DecoratorImplX( Component c )
    {
        super( c ) ;
    }

    public String op()
    {
        addedState = super.op() ;
        return addedBehavior( addedState ) ;
    }

    private String addedBehavior(String in) {
        return "<b>" + addedState + "</b>" ;
    }

}
