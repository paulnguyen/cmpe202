
public class M
{
    private T t1 = new T(1, 2) ;
    private T t2 = new T(2, 5) ;
    private T t3 = new T(3, 6) ;
    private T t4 = new T(4, 3) ;
    
    private N n = new N() ;
    private C c1 = new C() ;
    private C c2 = new C() ;
    
    public M() {
        t1.setNext(t2) ;
        t2.setNext(t3) ;
        t3.setNext(t4) ;
        n.setNext(c1)  ;
        c1.setNext(c2) ;
        t1.add(n) ;
        t2.add(n) ;
        t3.add(n) ;
        t4.add(n) ;
    }
    
    public void test() {
        try {
            T t = t1.reserve(5) ;
            t.dine() ;
            t.billed() ;
            t.paid() ;            
        } catch (Exception e ) {
            System.out.println( e ) ;
        }
    }
 
}
