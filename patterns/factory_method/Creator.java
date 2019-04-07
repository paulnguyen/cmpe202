package factory_method;

public abstract class Creator {

    String order = "Default Order" ;

	public abstract Engine getEngine();

	public void takeOrder(String order) {
        this.order = order ;
	}

	public void buildOrder() {
        Engine eng = getEngine() ;
        System.out.println( "Building Order: " + this.order );
        System.out.println( "Pull Engine..." + eng.getClass().getName() );
        System.out.println( "Assemble Car..." );
        System.out.println( "Paint...");
        System.out.println( "Ship...");
	}

}



