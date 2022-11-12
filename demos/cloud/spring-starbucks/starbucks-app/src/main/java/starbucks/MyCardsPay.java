/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen
{
    Card card ;
    
    public MyCardsPay()
    {
        card = Card.getInstance() ;
    }

    /**
     * Get Screen Display Contents
     * @return Screen Contents
     */
    public String display() {
        String result = "[" + card.getCardId() + "]\n" + "\n\n" + "Scan Now" ;
        String output = Utilities.center( result ) ;
        return output ;
    }

    /**
     * Touch (X,Y) Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        AppController app = AppController.getInstance() ;
        if ( x == 3 && y == 3 ) {
            app.setScreen( AppController.SCREENS.MY_CARDS_MAIN ) ;
        }            
        if ( x == 2 && y == 2 ) {
            card.pay() ; 
        }
    } 

}


