import java.util.ArrayList ;
import org.json.JSONObject ;
import org.json.JSONArray ;
import org.restlet.resource.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Main Class
 * 
 * @author Paul Nguyen
 * @version 1.0
 */
public class Main
{

    public static void main(String[] args) 
    {
    	String URL = "http://localhost:8080/cart" ;
    	//String URL = "http://aws.nguyenresearch.com:8080/cart" ;
    	ClientResource client = new ClientResource( URL );

    	Representation result_string = client.get() ; 
    	try {

      		JSONObject json = new JSONObject( result_string.getText() ) ;
      		JSONArray items = json.getJSONArray("items") ;

      		Order theOrder = new Order() ;
        	ITaxObserver orderObserver = theOrder ;

      		System.out.println( "\n\n=========================" ) ;
        	System.out.println( "INPUT: \n" ) ;
      		for ( int i = 0 ; i<items.length() ; i++ ) {
      			JSONObject item = items.getJSONObject(i) ;
      			System.out.println( item.get("qty") + "|" + item.get("description") + "|" + item.get("price") ) ;  
      			// Extract Order Item Details
      			int qty = item.getInt("qty") ;
            	String product = item.getString("description") ;
            	Double price = item.getDouble("price") ;            
          		// Build Order Line Item with Tax
            	OrderItem baseItem = new OrderItem( product, price, qty ) ;
            	IOrderItem orderItem = baseItem ;
	            // Decorate with Basic Tax
	            if (!isTaxExempt(product))
	            {
	            	  //System.out.println ("Not Tax Excempt! => " + product ) ;
	                IOrderItem basicTax = new BasicTaxDecorator(orderItem, orderObserver);
	                orderItem = basicTax ;
	            }
	            // Decorate with Import Tax
	            if (isImported(product))
	            {
	            	  //System.out.println ("Is Imported! => " + product ) ;
	                IOrderItem importTax = new ImportDutyDecorator(orderItem, orderObserver);
	                orderItem = importTax ;
	            }            	            
	            // Add Line Item to Order
	            theOrder.addLineItem( orderItem ) ;
      		}
      		theOrder.print() ;
      		System.out.println( "=========================\n\n" ) ;
    	}
    	catch (Exception e) {
      		System.out.println( e.getMessage() ) ;
    	}	          
  	}
       

    /**
     * Calculates if Product is Tax Excempt
     * 
     * @param  		product   	description of product
     * @return     	true 		if excempt, false otherwise.
     */
    private static boolean isTaxExempt(String product)
    { 
        String[] exemptProducts = { 
            "BOOK", 
            "CHOCOLATE",
            "PILLS"
        } ;      
        for (String e : exemptProducts)
        {
            //System.out.println( e ) ;
            int index = product.toUpperCase().indexOf(e);
            //System.out.println( index ) ;
            if (index >= 0)
                return true ;
        }
        return false ;
    }

    /**
     * Calculates if Product has Import Tax
     * 
     * @param  		product   	description of product
     * @return     	true 		if import duty applies, false otherwise.
     */    
    private static boolean isImported(String product)
    {    
        int index = product.toUpperCase().indexOf("IMPORTED");
        //System.out.println( index ) ;
        if (index >= 0)
            return true ;
        else
            return false ;
    }
    
}
