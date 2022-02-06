
public class T implements C1, B2
{
    private int id ;
    private int c_size ;
    private int p_size ;
    
    private E current ;
    private C1 next ;
    private S0 s0 = new S0(this) ;
    private S1 s1 = new S1(this) ;
    private S2 s2 = new S2(this) ;
    private S3 s3 = new S3(this) ;
    private S4 s4 = new S4(this) ;

    public T(int id, int size) { 
        current = s0 ; 
        this.id = id ;
        this.c_size = size ;
    }
    
    public int getId() { return this.id ; }
    public String getCurrentState() { return current.d() ; }
    
    public void setNext( C1 n ) {
        this.next = n ;
    }
    
    public T reserve( int size ) throws Exception { 
        if ( size > c_size || !current.d().equals("S0") ) {
            if ( this.next == null ) 
                throw new Exception() ;
            else 
                return next.reserve( size ) ;
        }
        this.p_size = size ;
        current.reserve() ; 
        System.out.println( "Reserved Table # " + String.valueOf(id) ) ;
        return this ;
    }
    public void cancel()    { current.cancel() ; }
    public void confirm()   { current.confirm() ; }
    public void dine()      { current.dine() ; }
    public void billed()    { current.billed() ; }
    public void paid()      { current.paid() ; }
    public void cleaned()   { current.cleaned() ; }
        
    void set_s0() { current = s0 ; s0.enter() ; }
    void set_s1() { current = s1 ; s1.enter() ; }
    void set_s2() { current = s2 ; s2.enter() ; }
    void set_s3() { current = s3 ; s3.enter() ; }
    void set_s4() { current = s4 ; s4.enter() ; }
    
    public void add( B1 o ) { s4.add(o) ; }
    public void remove()    { s4.remove() ; }
    public void update()    { s4.update() ; }    
    
    void debug() {
        System.out.println( "Current State: " + current.d() ) ;
        System.out.println( "Table Capacity: " + String.valueOf( c_size ) ) ;
        System.out.println( "Party Size: " + String.valueOf( p_size ) ) ;       
        System.out.println( "Dining Time: " + String.valueOf( s2.getElapsedTimeMins() ) ) ;
    }
    
}

