package abstract_factory;

public class PriusFactory extends AbstractFactory {

    public FactoryPart getEngine() {
        return new HybridEngine();
    }

    public FactoryPart getBody() {
        return new PriusBody();
    }

    public FactoryPart getOptions() {
        return new PriusOptions();
    }

}





