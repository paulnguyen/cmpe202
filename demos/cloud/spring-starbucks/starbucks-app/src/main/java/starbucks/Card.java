/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import java.text.NumberFormat ;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

/* 

    REST CLIENT:  

    http://unirest.io/java.html 
    https://www.baeldung.com/unirest
    http://stleary.github.io/JSON-java/index.html
    https://www.programcreek.com/java-api-examples/?api=com.mashape.unirest.http.Unirest

*/


/**
 * Card Class for Managing Card Balance & Transactions
 */
public class Card {

    private double balance = 0.00f ; // default
    private String cardId = "000000000" ;
    private String cardCode = "000" ;
    
    private static Card theCard = null ;
    
    public synchronized static Card getNewInstance() {
        theCard = new Card();
        theCard.setCard();
        return theCard;
    }
    
    public synchronized static Card getInstance() {
        if (theCard == null) {
            theCard = new Card();
            theCard.setCard();
            return theCard;
        }
        else
            return theCard;
    }

    private Card() { }

    // << Change Me!  Hard Coded to Get a Random Card for Now >>
    public void setCard()
    {
  
        Device theDevice = Device.getInstance() ;
        String apiurl = theDevice.getProps("apiurl") ;
        String apikey = theDevice.getProps("apikey") ;
        String register = theDevice.getProps("register") ;

        try {

            HttpResponse<JsonNode> response = Unirest.post( apiurl + "/cards")
                .header( "apikey", apikey )
                .asJson() ;
            JSONObject json = response.getBody().getObject() ;
            System.err.println( json.toString() ) ;

            this.cardId = json.getString( "cardNumber" ) ;
            this.cardCode = json.getString( "cardCode" ) ;
            this.balance = json.getDouble( "balance" )  ;     

            System.err.println( "New Card: " + cardId + "[" + cardCode + "] Balance: " + balance ) ;

           // activate it
           HttpResponse<JsonNode> response2 = Unirest.post( apiurl + "/card/activate/" + cardId + "/" + cardCode )
                .header( "apikey", apikey )
                .asJson() ;
            int status_code2 = response2.getStatus() ;
            String status_text2 = response2.getStatusText() ;
            System.err.println( "Status: " + String.valueOf(status_code2) + " " + status_text2 ) ;
            JSONObject json2 = response2.getBody().getObject() ;
            System.err.println( json2.toString() ) ;    


        } catch (Exception e) {

            System.err.println( e ) ;
            
        }
    }

    public String getCardId() {
        return cardId ;
    }
    
    public String getCardCode() {
        return cardCode ;
    }
    
    public String getBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(balance) ;        
    }

    public void pay() {

        Device theDevice = Device.getInstance() ;
        String apiurl = theDevice.getProps("apiurl") ;
        String apikey = theDevice.getProps("apikey") ;
        String register = theDevice.getProps("register") ;
        
        try {

            // create a new card
            HttpResponse<JsonNode> response = 
                Unirest.post( apiurl + "/order/register/"+register+"/pay/"+cardId)
                    .header( "apikey", apikey )
                    .asJson() ;
            JSONObject json = response.getBody().getObject() ;
            System.err.println( json.toString() ) ;

            double new_bal = json.getDouble( "balance" )  ;  
            this.balance = new_bal ;    

        } catch (Exception e) {

            System.err.println( e ) ;
            
        }

    }

    public void display()
    {
        System.err.format( "Card ID: %s%n", cardId ) ;
        System.err.format( "Card Balance: $%4.2f%n", balance ) ;
    }
}
 

