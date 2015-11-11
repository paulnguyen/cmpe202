package chain_of_responsibility;

public class ConcreteHandler2 implements Handler {

    private Handler successor = null;

    public void handleRequest( String request ) {
        System.out.println( "R2 got the request...");
        if ( request.equalsIgnoreCase("R2") )
        {
            System.out.println( this.getClass().getName() + " => This one is mine!");
        }
        else
        {
            if ( successor != null )
                successor.handleRequest(request);
        }

    }

    public void setSuccessor(Handler next) {
        this.successor = next ;
    }


}
