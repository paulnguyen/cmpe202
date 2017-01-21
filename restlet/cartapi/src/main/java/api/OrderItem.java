package api ;

class OrderItem {

    public int qty ;
    public String description ;
    public Double price ;

    public OrderItem( int qty, String desc, Double price )
    {
    	this.qty = qty ;
    	this.description = desc ;
    	this.price = price ;
    }

}