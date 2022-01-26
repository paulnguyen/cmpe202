package abstract_factory;

public class VolvoFactory extends AbstractFactory {

    @Override
	public FactoryPart getEngine() {
        return new GasEngine();
    }

    @Override
	public FactoryPart getBody() {
        return new VolvoBody();
    }

    @Override
	public FactoryPart getOptions() {
        return new VolvoOptions();
    }

}





