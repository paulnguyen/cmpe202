package abstract_factory;

public class VolvoFactory extends AbstractFactory {

    public FactoryPart getEngine() {
        return new GasEngine();
    }

    public FactoryPart getBody() {
        return new VolvoBody();
    }

    public FactoryPart getOptions() {
        return new VolvoOptions();
    }

}





