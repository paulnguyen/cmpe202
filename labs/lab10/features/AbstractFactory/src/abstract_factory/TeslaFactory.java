package abstract_factory;

public class TeslaFactory extends AbstractFactory {

    @Override
	public FactoryPart getEngine() {
        return new ElectricEngine();
    }

    @Override
	public FactoryPart getBody() {
        return new TeslaBody();
    }

    @Override
	public FactoryPart getOptions() {
        return new TeslaOptions();
    }
}




