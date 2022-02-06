
// waiting for cleanup
public class S4 implements E, B2
{
    private T m ;
    private B1 o ;
    public S4( T pm ) { this.m = pm ; }
    
    public void reserve() { }
    public void cancel() { }
    public void confirm() { }
    public void dine() { }
    public void billed() { }
    public void paid() { }
    public void cleaned() { m.set_s0() ; exit() ; }
    
    public void enter() { update() ; } 
    public void exit() { } 
    
    public void add( B1 o ) { this.o = o ; }
    public void remove() { this.o = null ; }
    public void update() { o.update(m.getId()) ; }
    
    public String d() { return "S4" ; }
}
