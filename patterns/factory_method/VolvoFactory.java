package factory_method;

public class VolvoFactory extends Creator {

	public Engine getEngine() {
		return new Gas();
	}

}
