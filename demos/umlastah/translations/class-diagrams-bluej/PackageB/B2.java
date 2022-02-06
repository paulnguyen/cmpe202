
package PackageB;

public class B2 {
	 
    PackageA.A1 a1 ;

    public B2()
    {
        a1 = new PackageA.A1() ;
    }

    public void accessPublicA1() {
        System.out.println( a1.publicA1 ) ;
    }
    
    public void accessProtectedA1() {
        //System.out.println( a1.protectedA1 ) ;
    }
    
    public void accessPackageA1() {
        //System.out.println( a1.packageA1 ) ;
    }
    
    public void accessPrivateA1() {
        //System.out.println( a1.privateA1 ) ;
    }    
          
}
 


