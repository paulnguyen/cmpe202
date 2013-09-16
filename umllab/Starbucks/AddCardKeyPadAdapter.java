/* Starbucks Mobile App Text Screen Simulator. By Paul Nguyen */


public class AddCardKeyPadAdapter implements TouchAdapter
{
    private KeyPad keypad ;
    private AddCardScreen screen ;

    public AddCardKeyPadAdapter(AddCardScreen scr )
    {
        this.keypad = new KeyPad() ;
        this.screen = scr ;
    }

    public void touch(int x, int y)
    {
        if ( y > 4 )
        {
            String key ;
            int kx, ky ;
            kx = x ; ky = y-4 ;
            key = this.keypad.keyPress(kx, ky) ;
            System.out.println( "Key => " + key ) ;
            screen.keyPressed(key) ;
        }
    }
}
