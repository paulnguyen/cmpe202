
public class Decorator implements Component {

    private Component component;

    public Decorator( Component c )
    {
        component = c ;
    }

    public String op()
    {
        return component.op() ;
    }

}
