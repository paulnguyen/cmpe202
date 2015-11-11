package factory_method;

public class TeslaFactory extends Creator {

	public Engine getEngine() {
        return new Electric() ;
	}

}
