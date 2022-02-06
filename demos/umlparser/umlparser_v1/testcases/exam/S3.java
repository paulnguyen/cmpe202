
// waiting for payment
public class S3 implements E
{
    private T m ;
    public S3( T pm ) { this.m = pm ; }
    
    public void reserve() { }
    public void cancel() { }
    public void confirm() { }
    public void dine() { }
    public void billed() { }
    public void paid() { m.set_s4() ; exit() ; }
    public void cleaned() { }
    
    public void enter() { } 
    public void exit() { } 
    
    public String d() { return "S3" ; }
}
