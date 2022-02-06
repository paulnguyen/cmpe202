
public class BuildOrder {
    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;

        // Get Custom Burgers
        CustomBurger customBurger1 = getBurger1() ;
        CustomBurger customBurger2 = getBurger2() ;

        // Add Custom Burger to the Order
        order.addChild( customBurger1 );    
        order.addChild( customBurger2 );    

        return order ;
    }

    private static CustomBurger getBurger1() {
        CustomBurger customBurger1 = new CustomBurger( "Build Your Own Burger" ) ;
        // Burger
        Burger b = new Burger( "Burger" ) ;
        String[] bo = { "Organic Bison*", "1/2lb.", "On A Bun" } ;
        b.setOptions( bo ) ;
        // Cheese
        Cheese c = new Cheese( "Cheese" ) ;
        String[] co = { "Yellow American", "Spicy Jalapeno Jack" } ;
        c.setOptions( co ) ;
        c.wrapDecorator( b ) ;
        // Premium Cheese
        PremiumCheese pc = new PremiumCheese( "Premium Cheese" ) ;
        String[] pco = { "Danish Blue Cheese" } ;
        pc.setOptions( pco ) ;
        pc.wrapDecorator( c ) ;
        // Sauce
        Sauce s = new Sauce( "Sauce" ) ;
        String[] so = { "Mayonnaise", "Thai Peanut Sauce" } ;
        s.setOptions( so ) ;
        s.wrapDecorator( pc ) ;
        // Unlimited Toppings
        UnlimitedToppings ut = new UnlimitedToppings( "Unlimited Toppings" ) ;
        String[] uto = { "Dill Pickle Chips", "Black Olives", "Spicy Pickles" } ;
        ut.setOptions( uto ) ;
        ut.wrapDecorator( s ) ;
        // Premium Toppings
        PremiumToppings pt = new PremiumToppings( "Premium Toppings" ) ;
        String[] pto = { "Marinated Tomatoes" } ;
        pt.setOptions( pto ) ;
        pt.wrapDecorator( ut ) ;
        // Bun Choice
        BunChoice bc = new BunChoice( "Bun Choice" ) ;
        String[] bco = { "Ciabatta (Vegan)" } ;
        bc.setOptions( bco ) ;
        bc.wrapDecorator( pt ) ;
        // Extra Sides
        ExtraSides ex = new ExtraSides( "Extra Sides" ) ;
        String[] exo = { "Shoestring Fries" } ;
        ex.setOptions( exo ) ;
        ex.wrapDecorator( bc ) ;

        // Setup Custom Burger Ingredients
        customBurger1.setDecorator( ex ) ;
        customBurger1.addChild( b ) ;
        customBurger1.addChild( c ) ;
        customBurger1.addChild( pc ) ;
        customBurger1.addChild( s ) ;        
        customBurger1.addChild( ut ) ;
        customBurger1.addChild( pt ) ;
        customBurger1.addChild( bc ) ;
        customBurger1.addChild( ex ) ;

        // return custom burger
        return customBurger1 ;
    }

    private static CustomBurger getBurger2() {

        CustomBurger customBurger2 = new CustomBurger( "Build Your Own Burger" ) ;

        // Burger
        Burger b = new Burger( "Burger" ) ;
        String[] bo = { "Hormone & Antibiotic Free Beef*", "1/3lb.", "On A Bun" } ;
        b.setOptions( bo ) ;
        // Cheese
        Cheese c = new Cheese( "Cheese" ) ;
        String[] co = { "Smoked Gouda", "Greek Feta" } ;
        c.setOptions( co ) ;
        c.wrapDecorator( b ) ;
        // Premium Cheese
        PremiumCheese pc = new PremiumCheese( "Premium Cheese" ) ;
        String[] pco = { "Fresh Mozzarella" } ;
        pc.setOptions( pco ) ;
        pc.wrapDecorator( c ) ;
        // Sauce
        Sauce s = new Sauce( "Sauce" ) ;
        String[] so = { "Habanero Salsa" } ;
        s.setOptions( so ) ;
        s.wrapDecorator( pc ) ;
        // Unlimited Toppings
        UnlimitedToppings ut = new UnlimitedToppings( "Unlimited Toppings" ) ;
        String[] uto = { "Crushed Peanuts" } ;
        ut.setOptions( uto ) ;
        ut.wrapDecorator( s ) ;
        // Premium Toppings
        PremiumToppings pt = new PremiumToppings( "Premium Toppings" ) ;
        String[] pto = { "Sunny Side Up Egg*", "Marinated Tomatoes" } ;
        pt.setOptions( pto ) ;
        pt.wrapDecorator( ut ) ;
        // Bun Choice
        BunChoice bc = new BunChoice( "Bun Choice" ) ;
        String[] bco = { "Gluten-Free Bun" } ;
        bc.setOptions( bco ) ;
        bc.wrapDecorator( pt ) ;
        // Extra Sides
        ExtraSides ex = new ExtraSides( "Extra Sides" ) ;
        String[] exo = { "Shoestring Fries" } ;
        ex.setOptions( exo ) ;
        ex.wrapDecorator( bc ) ;

        // Setup Custom Burger Ingredients
        customBurger2.setDecorator( ex ) ;
        customBurger2.addChild( b ) ;
        customBurger2.addChild( c ) ;
        customBurger2.addChild( pc ) ;
        customBurger2.addChild( s ) ;        
        customBurger2.addChild( ut ) ;
        customBurger2.addChild( pt ) ;
        customBurger2.addChild( bc ) ;
        customBurger2.addChild( ex ) ;   

        // return custom burger
        return customBurger2 ;
    }

}