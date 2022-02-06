
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Leaf implements Component {

    private String description ;
    private Double price ;

    public Leaf ( String d, Double p, IPackerFunc packer  )
    {
        description = d ;
        price = p ;
        packer.add( d ) ;
    }

    public String getDescription() {
        return description ;
    }

    public void doPrint()  {
        System.out.println( "  " + description ) ;
    }

    public void addChild(Component c) {
        // no implementation
    }

    public void removeChild(Component c) {
        // no implementation
    }

    public Component getChild(int i) {
        // no implementation
        return null ;
    }

}

