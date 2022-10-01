 

import java.util.ArrayList;

public class Composite implements Component {

    private ArrayList<Component> components = new ArrayList<Component>()  ;
    private String description ;
    private Double price ;
    
    public Composite ( String d, Double p, IPackerInit packer )
    {
        description = d ;
        price = p ;
        ArrayList<String> items = new ArrayList<String>()  ;
        packer.init( items ) ;
    }

    public String getDescription() {
        return description ;
    }
    
    public void doPrint() {
        System.out.println( description );
        for (Component obj  : components)
        {
            obj.doPrint() ;
        }
    }

    public void addChild(Component c) {
        components.add( c ) ;
    }
     
    public void removeChild(Component c) {
        components.remove(c) ;
    }
     
    public Component getChild(int i) {
        return components.get( i ) ;
    }
     
}
 
