package api ;

import java.util.ArrayList ;
import java.util.Random ;
import java.util.UUID ;

class Order {
	public String id = UUID.randomUUID().toString() ;
    public ArrayList<OrderItem> items = new ArrayList<OrderItem>() ;
}
