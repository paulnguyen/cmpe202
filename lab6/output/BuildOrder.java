  

public class BuildOrder {

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
       
        CustomBurger customBurger = new CustomBurger( "Build Your Own Burger" ) ;
        
        Burger b = new Burger( "Burger Options" ) ;
        String[] bo = { "LBB", "LBC", "LH" } ;
        b.setOptions( bo ) ;
        
        // All toppings free
        Toppings t = new Toppings( "Toppings Options" ) ;
        String[] to = { "LETTUCE", "TOMATO", "G ONION", "JALA Grilled" } ;
        t.setOptions( to ) ;
                       
        customBurger.addChild( b ) ;
        customBurger.addChild( t ) ;
               
        // Add Custom Burger to the ORder
        order.addChild( customBurger );
        return order ;
    }

}


