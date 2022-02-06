
package PackageA;


public class A1 {
 
    public int publicA1;
    protected int protectedA1 ;
    private int privateA1 ;
    int packageA1 ;
     
    public A1()
    {   
        this.publicA1 = 444 ;
        this.protectedA1 = 333 ;
        this.privateA1 = 222 ;
        this.packageA1 = 111 ;
    }
    
    public void accessPublicA1() {
        System.out.println( publicA1 ) ;
    }

    public void accessProtectedA1() {
        System.out.println( protectedA1 ) ;
    }

    public void accessPackageA1() {
        System.out.println( packageA1 ) ;
    }
    
    public void accessPrivateA1() {
        System.out.println( privateA1 ) ;
    }    
    
}
 

