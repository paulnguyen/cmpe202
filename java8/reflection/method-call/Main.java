

import java.lang.reflect.* ;

public class Main {

 public static void main ( String[] args ) {
      try {

            String className = "GumballMachine" ;

            System.out.println( "Getting Class: PackageManager" ) ;
            Class c = Class.forName( "PackageManager" ) ;
            System.out.println( "Class Handle: " + c );
            System.out.println( "Getting Class Method: getManagedComponentForClass" ) ;
            Method m = c.getMethod( "getManagedComponentForClass", new Class[] { String.class } ) ;
            System.out.println( "Method Handle: " + m ) ;
            System.out.println( "Invoking Class Method with arg: " + className ) ;

            ManagedComponent obj =
              (ManagedComponent) m.invoke( null, new Object[] { className } ) ; // class method

            if ( obj == null ) {
              System.out.println( "Managed Component Not Found For: " + className ) ;
            }
            else {
              String ver = obj.getClassVersion() ;
              System.out.println( "\n\n" + className + " = " + ver ) ;
            }

      } catch ( Exception e ) {
              System.out.println( e ) ;
      }
  }
}