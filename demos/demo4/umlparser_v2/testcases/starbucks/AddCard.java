/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen
{
    public AddCard()
    {
    }

   /**
     * Frame Next Screen
     */
    public void next() {
    	// << Change Me!  Hard Coded to Get a Random Card for Now >>
        Card card = Card.getInstance() ;
        card.setCard() ; 
    }


}
