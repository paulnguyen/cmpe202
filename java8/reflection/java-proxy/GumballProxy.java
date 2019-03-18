

import java.lang.reflect.* ;

public class GumballProxy implements InvocationHandler {

  private final GumballMachine proxied;

  public GumballProxy(GumballMachine proxied) {
    this.proxied = proxied;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

  	System.out.println( "PROXY (BEFORE): " + method.getName() ) ;

   	Object result = null ;

   	try { 

   		result =  method.invoke(proxied, args) ;

   	}  catch (InvocationTargetException e) {

   		 System.out.println( "PROXY (ERROR): " + e ) ;
      	throw e.getTargetException() ;

  	} catch ( Exception e ) {

   		throw new RuntimeException( e ) ;

   	} finally {

   		System.out.println( "PROXY (AFTER): " + method.getName() ) ;
      
   	}

    return result;

  }

}