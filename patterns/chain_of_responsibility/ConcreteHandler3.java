package chain_of_responsibility;

public class ConcreteHandler3 implements Handler {


    private Handler successor = null;

    public void handleRequest( String request ) {
        System.out.println( "R3 got the request...");
        if ( request.equalsIgnoreCase("R3") )
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
