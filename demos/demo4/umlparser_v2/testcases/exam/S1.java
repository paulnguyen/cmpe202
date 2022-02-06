
// reserved
public class S1 implements E
{
    private T m ;
    public S1( T pm ) { this.m = pm ; }
    
    public void reserve() { }
    public void cancel() { m.set_s0() ; }
    public void confirm() { m.set_s1() ; }
    public void dine() { m.set_s2() ; exit() ; }
    public void billed() { }
    public void paid() { }
    public void cleaned() { }

    public void enter() { } 
    public void exit() { } 
    
    public String d() { return "S1" ; }
}

