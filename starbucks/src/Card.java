/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */

public class Card {

    private float balance = 16.50f ; // default
    private String cardId = "1234567890123456" ;
    private String cardCode = "11111111" ;

    public Card()
    {
    }

    public Card(String id, String code)
    {
        this.cardId = id ;
        this.cardCode = code ;
    }

    public String getBalance() {
        return Float.toString(balance);
    }

    public void pay(float amt) {
        this.balance -= amt ;
    }

    public void display()
    {
        System.out.format( "Card ID: %s\n", cardId ) ;
        System.out.format( "Card Balance: %4.2f\n", balance ) ;
    }
}
 
