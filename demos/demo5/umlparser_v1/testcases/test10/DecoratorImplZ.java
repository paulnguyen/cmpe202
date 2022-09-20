
public class DecoratorImplZ extends Decorator {

	private String addedState;

    public DecoratorImplZ( Component c )
    {
        super( c ) ;
    }

    public String op()
    {
        addedState = super.op() ;
        return addedBehavior( addedState ) ;
    }

	private String addedBehavior(String in) {
		return "<em>" + addedState + "</em>" ;
	}

}
