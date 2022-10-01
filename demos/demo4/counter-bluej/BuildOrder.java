  

public class BuildOrder {

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
        order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
        order.addChild(new Leaf("The Purist", 8.00 ));

        CustomBurger customBurger = new CustomBurger( "Build Your Own Burger" ) ;
        // base price for 1/3 lb
        Burger b = new Burger( "Burger Options" ) ;
        String[] bo = { "Beef", "1/3lb.", "On A Bun" } ;
        b.setOptions( bo ) ;
        // 1 cheese free, extra cheese +1.00
        Cheese c = new Cheese( "Cheese Options" ) ;
        String[] co = { "Danish Blue Cheese", "Horseradish Cheddar" } ;
        c.setOptions( co ) ;
        c.wrapDecorator( b ) ;
        // 4 toppings free, extra +.75
        Toppings t = new Toppings( "Toppings Options" ) ;
        String[] to = { "Bermuda Red Onion", "Black Olives", "Carrot Strings", "Coleslaw" } ;
        t.setOptions( to ) ;
        t.wrapDecorator( c ) ;
        // premium topping +1.50
        Premium p = new Premium( "Premium Options" ) ;
        String[] po = { "Applewood Smoked Bacon" } ;
        p.setOptions( po ) ;
        p.wrapDecorator( t ) ;
        // 1 sauce free, extra +.75
        Sauce s = new Sauce( "Sauce Options" ) ;
        String[] so = { "Appricot Sauce" } ;
        s.setOptions( so ) ;
        s.wrapDecorator( p ) ;
        
        // Setup Custom Burger Ingredients
        customBurger.setDecorator( s ) ;
        customBurger.addChild( b ) ;
        customBurger.addChild( c ) ;
        customBurger.addChild( t ) ;
        customBurger.addChild( p ) ;
        customBurger.addChild( s ) ;
        
        // Add Custom Burger to the ORder
        order.addChild( customBurger );
        return order ;
    }

}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/