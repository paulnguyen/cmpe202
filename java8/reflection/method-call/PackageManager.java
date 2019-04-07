
import java.lang.reflect.* ;
import java.io.* ;

public abstract class PackageManager {

  private static boolean debug = false ;

  public static ManagedComponent getManagedComponent() {
    return new ManagedComponent() {
      public String getClassVersion() {  return "1.0" ; }
      public String getFlags() { return "DEBUG: " + debug  ; }
      public String debugOn() { debug = true ; return "Debug Has Been Turned On."; }
      public String debugOff() { debug = false ; return "Debug Has Been Turned Off."; }
    } ;
  }

  public static ManagedComponent getManagedComponentForClass( String className )
  {
    try
    {
        if (debug) System.out.println( "Getting ManagedComponent For Class: " + className ) ;
        Class c = Class.forName( className ) ;
        if (debug) System.out.println( "Class Handle: " + c );
        if (debug) System.out.println( "Getting Class Method: getManagedComponent" ) ;
        Method m = c.getMethod( "getManagedComponent", null ) ; // no args
        if (debug) System.out.println( "Method Handle: " + m ) ;
        if (debug) System.out.println( "Invoking..." ) ;
        ManagedComponent obj = (ManagedComponent) m.invoke( null, null ) ; // class method, no args
        if (debug) System.out.println( "Got Object: " + obj ) ;
        return obj ;
    }
    catch ( Exception e )
    {
      System.out.println( e ) ;
      return null ;
    }
  }

  public static String invokeManagedMethodNoArgs( String className, String methodName )
    throws Exception
  {
      try {

        if (debug) System.out.println( "Getting ManagedComponent For Class: " + className ) ;
        Class c = Class.forName( className ) ;
        if (debug) System.out.println( "Class Handle: " + c );
        if (debug) System.out.println( "Getting Class Method: getManagedComponent" ) ;
        Method m = c.getMethod( "getManagedComponent", null ) ; // no args
        if (debug) System.out.println( "Method Handle: " + m ) ;
        if (debug) System.out.println( "Invoking..." ) ;
        ManagedComponent obj =
          (ManagedComponent) m.invoke( null, null ) ; // class method, no args
        if (debug) System.out.println( "Got Object: " + obj ) ;

        if ( obj == null ) {
          if (debug) System.out.println( "Managed Component Not Found For: " + className ) ;
          throw new Exception( "Managed Component Not Found For: " + className ) ;
        }
        else {
          Method mm = null ;
          String result = "" ;

          if (debug) System.out.println( "Getting class of managed object... " ) ;
          Class mc = obj.getClass() ;
          if (debug) System.out.println( "Managed Class Handle: " + mc );
          if (debug) System.out.println( "Looking for requested method..." ) ;
          try { mm = mc.getMethod( methodName, null ) ; } catch (Exception e) {}

          if ( mm != null ) {
            if (debug) System.out.println( "Managed Method Handle: " + mm );
            if (debug) System.out.println( "Invoking Managed Method..." ) ;
            if ( mm.getParameterTypes().length > 0 )
              result = (String) mm.invoke( obj, new Object[] { null } ) ;
            else
              result = (String) mm.invoke( obj, null ) ;
          }
          else {
            mm = mc.getMethod( methodName, new Class[] { String[].class } ) ;
            if (debug) System.out.println( "Managed Method Handle (Args): " + mm );
            if (debug) System.out.println( "Invoking Managed Method..." ) ;
            result = (String) mm.invoke( obj, new Object[] { null } ) ;
          }

          if (debug) System.out.println( "Result: " + result ) ;
          return result ;
        }

      } catch ( Exception e ) {
              System.out.println( e ) ;
              throw e ;
      }
  }

  public static String invokeManagedMethodWithArgs( String className,
    String methodName, String[] methodArgs )
    throws Exception
  {
      try {

        if (debug) System.out.println( "Getting ManagedComponent For Class: " + className ) ;
        Class c = Class.forName( className ) ;
        if (debug) System.out.println( "Class Handle: " + c );
        if (debug) System.out.println( "Getting Class Method: getManagedComponent" ) ;
        Method m = c.getMethod( "getManagedComponent", null ) ; // no args
        if (debug) System.out.println( "Method Handle: " + m ) ;
        if (debug) System.out.println( "Invoking..." ) ;
        ManagedComponent obj =
          (ManagedComponent) m.invoke( null, null ) ; // class method, no args
        if (debug) System.out.println( "Got Object: " + obj ) ;

        if ( obj == null ) {
          if (debug) System.out.println( "Managed Component Not Found For: " + className ) ;
          throw new Exception( "Managed Component Not Found For: " + className ) ;
        }
        else {
          if (debug) System.out.println( "Getting class of managed object... " ) ;
          Class mc = obj.getClass() ;
          if (debug) System.out.println( "Managed Class Handle: " + mc );
          if (debug) System.out.println( "Looking for requested method..." ) ;
          Method mm = mc.getMethod( methodName, new Class[] { String[].class } ) ;
          if (debug) System.out.println( "Managed Method Handle: " + mm );
          if (debug) System.out.println( "Invoking Managed Method..." ) ;
          String result = (String) mm.invoke( obj, new Object[] { methodArgs } ) ;
          if (debug) System.out.println( "Result: " + result ) ;
          return result ;
        }

      } catch ( Exception e ) {
              System.out.println( e ) ;
              throw e ;
      }
  }



}
