

import java.net.* ;
import java.util.* ;
import java.io.* ;
import org.json.* ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/*
   Defines a single test case running in its own thread.
   Each test case connects to a URL (via HTTP GET) and
   grabs the number of bytes or error condition.
*/
public class RunLoadTest {

   /** URL to run the test */
   private String myURL ;  
   /** Request Counter to track number of repeated requests */
   private int reqCount ;  
   /** Group of Threads Running HTTP GETS on List of URLs */
   private ThreadGroup myGroup ;  
   /** Used to Signal a Stop Request to all running threads */
   private static boolean out_of_time = false ;  

   /*
   Constructor which assigns the thread to a group and its source URL.
   @param grp Thread Group
   @param srcURL URL specification
   */
   RunLoadTest( ThreadGroup grp, String srcURL ) 
   {
      this.myURL = srcURL ;
      this.reqCount = 0 ;
      this.myGroup = grp ;    
   }

   /*
   Signal the all threads to stop processing
   */
   public static void setOutOfTime() 
   {
      out_of_time = true ;
   }
   
   /*
   Test for threads to check for stop processing signal
   @return true, if out of time; otherwise, false.
   */
   public static boolean isOutOfTime() 
   {
      return out_of_time ;        
   }
   
   /*
   Creates a thread and runs a test case
   */   
   public void runTest() 
   {
         // anonymous inner class for thread target
         Thread myThread = new Thread ( 
               this.myGroup,
               new Runnable() 
               {
                    public void run() 
                    {
                           while( !RunLoadTest.isOutOfTime() ) 
                           {
                                 doTest() ;
                                 try { Thread.sleep( 500 ) ; }
                                 catch ( InterruptedException e ) {
                                    System.out.println( e.getMessage() ) ;
                                 }
                            }
                            System.out.println( "Test " + myGroup + " Stopped! ==> " + reqCount + " Runs.") ;
                    }
               }
         ) ;
      
         myThread.start() ;
   }

   /*
   Performs a test by sending HTTP Gets to the URL,
   and records the number of bytes returned.  Each
   test results are documented and displayed in
   standard out with the following information:

   URL - The source URL of the test
   REQ CNT - How many times this test has run 
   START - The start time of the last test run 
   STOP - The stop time of the last test run 
   THREAD - The thread id handling this test case 
   RESULT - The result of the test.  Either the number of bytes returned or an error message.
   */
   private void doTest() 
   {
      String result = "" ;
      this.reqCount++ ;

       // Connect and run test steps
      Date startTime = new Date() ;
      try {
         ClientResource client = new ClientResource( this.myURL ); 

         // Insert Quarter
         JSONObject json_insert_quarter = new JSONObject();
         json_insert_quarter.put("action", "insert-quarter");
         client.post(new JsonRepresentation(json_insert_quarter), MediaType.APPLICATION_JSON);

         // Turn Crank
         JSONObject json_turn_crank = new JSONObject();
         json_turn_crank.put("action", "turn-crank");
         client.post(new JsonRepresentation(json_turn_crank), MediaType.APPLICATION_JSON);

         // Get Gumball Count
         Representation result_string = client.get() ; 
         JSONObject json_count = new JSONObject( result_string.getText() ) ;
         result = Integer.toString( (int)json_count.get("count") ) ;   
      }
      catch ( Exception e ) {
            result = e.toString() ;
      }
      finally {
         Date stopTime = new Date() ;
         // Print Report of Result:
         System.out.println( "======================================\n" +
            "URL     => " + this.myURL + "\n" +
            "REQ CNT => " + this.reqCount + "\n" +
            "START   => " + startTime + "\n" +
            "STOP    => " + stopTime + "\n" +
            "THREAD  => " + Thread.currentThread().getName() + "\n" +
            "RESULT  => " + result + "\n" ) ;
      }
   }


   /*
   Main Class Routine that reads in URL specs from a file and a duration (in miliseconds)
   of how long to run the test.
   
   USAGE: java RunLoadTest [Duration in seconds]</b>
   */
   public static void main( String[] args ) 
   {
      if ( args.length == 1 ) 
      {
         // Record Start of Test Run
         Date testStart = new Date() ; 
         System.out.println( "Start Test Run: " + testStart.toString() ) ;       

         // Load and run tests
         loadThread( "Test Group #1") ;
         loadThread( "Test Group #2") ;
         loadThread( "Test Group #3") ;
         loadThread( "Test Group #4") ;
         loadThread( "Test Group #5") ;

         // Set Timer to stop testing
         Timer timer = new Timer() ;
         TimerTask task = new TimerTask() 
         {
            public void run() 
            {
               Date testStop = new Date() ;
               RunLoadTest.setOutOfTime() ;
               try { Thread.sleep(3000); } catch ( Exception e ) {}  
               // Pause to allow all threads to stop.
               System.out.println( "Stop Test Run: " + testStop.toString() ) ;   
            }
         } ;

         // Schedule Test Run according to the duration given
         long curDate = new Date().getTime() ;
         long milis = Long.parseLong( args[0] ) * 1000 ;
         timer.schedule( task, new Date( curDate + milis) );
      }
      else {
         System.out.println( "USAGE: java RunLoadTest [Duration in seconds]" ) ;
      }
   }

   /*
   Helper method for main to load tests into a thread group and start each test case.
   */
   private static void loadThread( String name ) {              
      try {
         ThreadGroup myThreadGroup = new ThreadGroup( name ) ;     
         String urlSpec = "http://localhost:8080/gumball" ;  
         RunLoadTest test = new RunLoadTest( myThreadGroup, urlSpec ) ;
         test.runTest() ;  // Run The Test in its own thread
         myThreadGroup.list() ; 
      } catch ( Exception e ) {
         System.out.println( "ERROR: " + e.getMessage() );
      }
   }



}
