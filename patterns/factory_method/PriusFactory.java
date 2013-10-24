package factory_method;

public class PriusFactory extends Creator {

	public Engine getEngine() {
		return new Hybrid();
	}

}


