

import net.sf.cglib.proxy.* ;

public class Main2 {

	public static void main( String vargs[] ) {

		Enhancer enhancer = new Enhancer();
		
		enhancer.setSuperclass(GumballMachine.class);

		enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {

				System.out.println( proxy.getSignature().toString() ) ;

			    if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
			        return "*** Ignore Other Classes ***" ;

			    } else {

				   	Object result = null ;

				   	try {

				   		System.out.println( "PROXY (BEFORE): " + method.getName() ) ;
				   		result =  proxy.invokeSuper(obj, args) ;

				  	} catch ( Exception e ) {

				   		throw new RuntimeException( e ) ;

				   	} finally {

				   		System.out.println( "PROXY (AFTER): " + method.getName() ) ;

				   	}

				    return result;
			    }
			}
		) ;
		 
		GumballMachine proxy = (GumballMachine) enhancer.create();

        proxy.dumpConfig() ;
        proxy.insertCoinValue(25) ;
        proxy.insertCoinValue(25) ;


	}


}