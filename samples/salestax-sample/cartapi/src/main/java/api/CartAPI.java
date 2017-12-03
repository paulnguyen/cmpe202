package api ;

import java.util.ArrayList ;
import java.util.Random ;

public class CartAPI {

    private static ArrayList<Order> orders = new ArrayList<Order>() ;

    public static Order getOrder() {
        Random rn = new Random();
        int idx = rn.nextInt(6);
        return CartAPI.orders.get( idx ) ;
    }

    public static void generateOrders() {

        Order order1 = new Order() ;
        order1.items.add( new OrderItem(1,"Book", 12.49) ) ;
        order1.items.add( new OrderItem(1,"Music CD", 14.99) ) ;
        order1.items.add( new OrderItem(1,"Chocolate Bar", 0.85) ) ;
        CartAPI.orders.add( order1 ) ;

        Order order2 = new Order() ;
        order2.items.add( new OrderItem(1,"Box of Imported Chocolates", 10.00) ) ;
        order2.items.add( new OrderItem(1,"Bottle of Imported Perfume", 47.50) ) ;
        CartAPI.orders.add( order2 ) ;

        Order order3 = new Order() ;
        order3.items.add( new OrderItem(1,"Bottle of Imported Perfume", 27.99) ) ;
        order3.items.add( new OrderItem(1,"Bottle of Perfume", 18.99) ) ;
        order3.items.add( new OrderItem(1,"Packet of Headache Pills", 9.75) ) ;
        order3.items.add( new OrderItem(1,"Box of Imported Chocolates", 11.25) ) ;
        CartAPI.orders.add( order3 ) ;

        Order order4 = new Order() ;
        order4.items.add( new OrderItem(2,"Book", 12.49) ) ;
        order4.items.add( new OrderItem(2,"Music CD", 14.99) ) ;
        order4.items.add( new OrderItem(1,"Chocolate Bar", 0.85) ) ;
        CartAPI.orders.add( order4 ) ;

        Order order5 = new Order() ;
        order5.items.add( new OrderItem(1,"Box of Imported Chocolates", 10.00) ) ;
        order5.items.add( new OrderItem(5,"Bottle of Imported Perfume", 47.50) ) ;
        CartAPI.orders.add( order5 ) ;

        Order order6 = new Order() ;
        order6.items.add( new OrderItem(1,"Bottle of Imported Perfume", 27.99) ) ;
        order6.items.add( new OrderItem(2,"Bottle of Perfume", 18.99) ) ;
        order6.items.add( new OrderItem(1,"Packet of Headache Pills", 9.75) ) ;
        order6.items.add( new OrderItem(2,"Box of Imported Chocolates", 11.25) ) ;
        CartAPI.orders.add( order6 ) ;

        
    }

}


/*

1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

1 imported box of chocolates at 10.00 
1 imported bottle of perfume at 47.50

1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25

*/