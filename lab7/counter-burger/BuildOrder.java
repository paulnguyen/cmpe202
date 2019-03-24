  

public class BuildOrder {

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
        //order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
        //order.addChild(new Leaf("The Purist", 8.00 ));

        CustomBurger customBurger1 = new CustomBurger( "Build Your Own Burger" ) ;
        CustomBurger customBurger2 = new CustomBurger( "Build Your Own Burger" ) ;
        
        // base price for 1/2 lb 
        Burger b1 = new Burger( "Burger Options" ) ;
        String[] bo1 = { "Organic Bison*", "1/2lb.", "On A Bun" } ;
        b1.setOptions( bo1 ) ;
        
        // base price for 1/3 lb
        Burger b2 = new Burger( "Burger Options" ) ;
        String[] bo2 = { "Hormone & Antibiotic Free Beef*", "1/3lb.", "On A Bun" } ;
        b2.setOptions( bo2 ) ;
        
        // 1 cheese free, extra cheese +1.00
        Cheese c1 = new Cheese( "Cheese Options" ) ;
        String[] co1 = { "Yellow American", "Spicy Jalapeno Jack" } ;
        c1.setOptions( co1 ) ;
        c1.wrapDecorator( b1 ) ;
        
        // Setting up for the second burger
        Cheese c2 = new Cheese( "Cheese Options" ) ;
        String[] co2 = { "Smoked Gouda", "Greek Feta" } ;
        c2.setOptions( co2 ) ;
        c2.wrapDecorator( b2 ) ;
        
        // 1 premium cheese 1.50, extra premium cheese +1.50
        PremiumCheese pc1 = new PremiumCheese( "Premium Cheese Options" ) ;
        String[] pco1 = { "Danish Blue Cheese" } ;
        pc1.setOptions( pco1 ) ;
        pc1.wrapDecorator( c1 ) ;
        
        // Setting up for the second burger
        PremiumCheese pc2 = new PremiumCheese( "Premium Cheese Options" ) ;
        String[] pco2 = { "Fresh Mozzarella"} ;
        pc2.setOptions( pco2 ) ;
        pc2.wrapDecorator( c2 ) ;
        
        // 1 sauce free, extra +.50
        Sauce s1 = new Sauce( "Sauce Options" ) ;
        String[] so1 = { "Mayonnaise", "Thai Peanut Sauce" } ;
        s1.setOptions( so1 ) ;
        s1.wrapDecorator( pc1 ) ;
        
        // Setting up for the second burger
        Sauce s2 = new Sauce( "Sauce Options" ) ;
        String[] so2 = { "Habanero Salsa" } ;
        s2.setOptions( so2 ) ;
        s2.wrapDecorator( pc2 ) ;
        
        // all toppings are free
        Toppings t1 = new Toppings( "Toppings Options" ) ;
        String[] to1 = { "Dill Pickle Chips", "Black Olives", "Spicy Pickles" } ;
        t1.setOptions( to1 ) ;
        t1.wrapDecorator( s1 ) ;
        
        // Setting up for the second burger
        Toppings t2 = new Toppings( "Toppings Options" ) ;
        String[] to2 = { "Crushed Peanuts"} ;
        t2.setOptions( to2 ) ;
        t2.wrapDecorator( s2 ) ;
         
        // premium topping +1.00, except Marinated Tomatoes +3.00
        Premium p1 = new Premium( "Premium Options" ) ;
        String[] po1 = { "Marinated Tomatoes" } ;
        p1.setOptions( po1 ) ;
        p1.wrapDecorator( t1 ) ;
        
        // Setting up for the second burger
        Premium p2 = new Premium( "Premium Options" ) ;
        String[] po2 = { "Sunny Side Up Egg*", "Marinated Tomatoes" } ;
        p2.setOptions( po2 ) ;
        p2.wrapDecorator( t2 ) ;
        
        // Choose a Bun
        Bun bun1 = new Bun( "Bun Options" ) ;
        String[] buno1 = { "Ciabatta (Vegan)" } ;
        bun1.setOptions( buno1 ) ;
        bun1.wrapDecorator( p1 ) ;
        
        // Setting up for the second burger
        Bun bun2 = new Bun( "Bun Options" ) ;
        String[] buno2 = { "Gluten-Free Bun" } ;
        bun2.setOptions( buno2 ) ;
        bun2.wrapDecorator( p2 ) ;
        
        // Choose a Side
        Side side1 = new Side( "Side Options" ) ;
        String[] sideo1 = { "Shoestring Fries" } ;
        side1.setOptions( sideo1 ) ;
        side1.wrapDecorator( bun1 ) ;
        
        // Setting up for the second burger
        Side side2 = new Side( "Side Options" ) ;
        String[] sideo2 = { "Shoestring Fries" } ;
        side2.setOptions( sideo1 ) ;
        side2.wrapDecorator( bun2 ) ;
       
        // Setup Custom Burger Ingredients for the first burger
        customBurger1.setDecorator( side1 ) ;
        customBurger1.addChild( b1 ) ;
        customBurger1.addChild( c1 ) ;
        customBurger1.addChild( pc1 ) ;
        customBurger1.addChild( s1 ) ;
        customBurger1.addChild( t1 ) ;
        customBurger1.addChild( p1 ) ;
        customBurger1.addChild( bun1 ) ;
        customBurger1.addChild( side1 ) ;
                       
        // Setup Custom Burger Ingredients for the second burger
        customBurger2.setDecorator( side2 ) ;
        customBurger2.addChild( b2 ) ;
        customBurger2.addChild( c2 ) ;
        customBurger2.addChild( pc2 ) ;
        customBurger2.addChild( s2 ) ;
        customBurger2.addChild( t2 ) ;
        customBurger2.addChild( p2 ) ;
        customBurger2.addChild( bun2 ) ;
        customBurger2.addChild( side2 ) ;
        
        // Add Custom Burger to the Order
        order.addChild( customBurger1 );
        order.addChild( customBurger2 );
        return order ;
    }

}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/