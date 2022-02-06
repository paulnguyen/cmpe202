
// dining
public class S2 implements E
{
    private T m ;
    private long startTime = 0;
    private long stopTime = 0;

    public S2( T pm ) { this.m = pm ; }

    public void reserve() { }
    public void cancel() { }
    public void confirm() { }
    public void dine() { }
    public void billed() { m.set_s3() ; exit() ; }
    public void paid() { }
    public void cleaned() { }
    
    public void enter() { start() ; } 
    public void exit() { stop() ; } 

    public String d() { return "S2" ; }

    private void start() {
        startTime = System.currentTimeMillis() ;
    }

    private void stop() {
        stopTime = System.currentTimeMillis() ;
    }

    public long getElapsedTimeSecs() {
        return ((stopTime - startTime) / 1000) ;
    }

    public long getElapsedTimeMins() {
        return ((stopTime - startTime) / 1000)/60 ;
    }
}
