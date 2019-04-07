package abstract_factory;

public class TeslaFactory extends AbstractFactory {

    public FactoryPart getEngine() {
        return new ElectricEngine();
    }

    public FactoryPart getBody() {
        return new TeslaBody();
    }

    public FactoryPart getOptions() {
        return new TeslaOptions();
    }
}




