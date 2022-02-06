
public class N extends B
{

    public N() {
    }
    
    public void update( int id ) {
        System.out.println( "Notify Party" ) ;
        if (next != null )
            next.update( id ) ;
    }
        

}
