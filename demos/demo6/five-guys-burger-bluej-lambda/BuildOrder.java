   
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Character;

interface IPackerFunc { 
    void add(String item) ; 
} 

interface IPackerInit { 
    void init(ArrayList<String> items) ;
} 

public class BuildOrder {

    private HashMap<String, ArrayList<String>> packing = new HashMap<String, ArrayList<String>>();
    
    Composite order ;
    
    public Component getOrder()
    {
        order = new Composite( "Order", 0.0, (v) -> packing.put("Order",v) ) ;
        order.addChild(new Leaf("LTL CAJ", 2.79, (i) -> packing.get("Order").add(i)  ));
        Composite customBurger = new Composite( "LBB", 5.59, (v) -> packing.put("LBB",v) ) ;
        customBurger.addChild(new Leaf("{{{{ BACON }}}}", 0.00, (i) -> packing.get("LBB").add(i) ));
        customBurger.addChild(new Leaf("LETTUCE", 0.00, (i) -> packing.get("LBB").add(i)  )); 
        customBurger.addChild(new Leaf("TOMATO", 0.00, (i) -> packing.get("LBB").add(i)  )); 
        customBurger.addChild(new Leaf("->|G ONION", 0.00, (i) -> packing.get("LBB").add(i)  )); 
        customBurger.addChild(new Leaf("->|JAJA Grilled", 0.00, (i) -> packing.get("LBB").add(i) )); 
        order.addChild( customBurger );
        
        return order ;
    }


    interface IPackerPrintStrategy { 
         void print(ArrayList<String> items) ; 
    }  

    private void printPackingSlip( IPackerPrintStrategy print_strategy ) {
        
        for (String key : packing.keySet()) {
            System.out.println( "\n" + "** " + key + " **" ) ;
            ArrayList<String> items = packing.get(key);
            print_strategy.print( items ) ;
        }
    }    
    
    public void doPrintPackingSlip() {
        //System.out.println( packing + "\n") ;
        
        IPackerPrintStrategy nosort = (i) -> {  
            i.forEach( d -> { System.out.println( d ); } ) ;
        } ;	

        IPackerPrintStrategy sort = (i) -> {  
            ArrayList<String> items = new ArrayList<String>()  ;
            i.forEach( d -> { 
                char c = d.charAt(0) ;
                if ( Character.isLetterOrDigit(c) )
                    System.out.println( d ); 
                else
                    items.add(d) ;
            } ) ;
            Collections.sort(items) ;
            items.forEach( d -> { System.out.println( d ); } ) ;
        } ;	        
        
        printPackingSlip( sort ) ;

    }
}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/