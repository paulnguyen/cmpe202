
public class C extends B
{
    boolean busy = false ;

    public C() {
    }

    public void setBusy( boolean state ) {
        this.busy = state ;
    }
    
    public void update( int id ) {
        if ( !busy ) {
            busy = true ;
            System.out.println( "Cleaning Table # " + String.valueOf( id ) ) ;
        } else {
            if ( next != null )
                next.update( id ) ;
        }
    }
    
}
