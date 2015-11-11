package command;

import java.util.HashMap;

public class Menu {
 
	private HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>() ;
    
    public void addMenuItem( MenuItem item, String key ) {
        menuItems.put( key, item ) ;
    }

    public void selectMenuItem( String key ) {
        MenuItem item = menuItems.get(key) ;
        if ( item != null )
            item.invoke();
        else
            System.out.println( "Menu Item Not Found: " + key );
    }
	 
}
 
