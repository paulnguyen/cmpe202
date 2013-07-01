package composite;

import java.util.ArrayList;

public class Composite implements Component {

    private ArrayList<Component> components = new ArrayList<Component>()  ;
    private String description ;
    
    public Composite ( String d )
    {
        description = d ;
    }

	public void printDescription() {
        System.out.println( description );
        for (Component obj  : components)
        {
            obj.printDescription();
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
 
