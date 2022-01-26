package abstract_factory;

public abstract class AbstractFactory {

    String order = "Default Order" ;

	public abstract FactoryPart getEngine();
	public abstract FactoryPart getBody();
	public abstract FactoryPart getOptions();

    public void takeOrder(String order) {
        this.order = order ;
    }

    public void buildOrder() {
        FactoryPart engine = getEngine() ;
        FactoryPart body = getBody() ;
        FactoryPart options = getOptions() ;

        System.out.println( "Building Order: " + this.order );
        System.out.println( "Pull Engine..." + engine.getClass().getName() );
        System.out.println( "Pull Body..." + body.getClass().getName() );
        System.out.println( "Pull Options..." + options.getClass().getName() );
        System.out.println( "Assemble Car..." );
        System.out.println( "Paint...");
        System.out.println( "Ship...");
    }

}
