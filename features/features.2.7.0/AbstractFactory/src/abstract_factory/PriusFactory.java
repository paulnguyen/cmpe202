package abstract_factory;

public class PriusFactory extends AbstractFactory {

    @Override
	public FactoryPart getEngine() {
        return new HybridEngine();
    }

    @Override
	public FactoryPart getBody() {
        return new PriusBody();
    }

    @Override
	public FactoryPart getOptions() {
        return new PriusOptions();
    }

}





