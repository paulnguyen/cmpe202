public class ConcreteDecoratorSpace extends Decorator{

    private String addedData;

    public ConcreteDecoratorSpace(ICardDecorator c){
        super (c);
    }

    public String addCharacter(String data){
        addedData = addedBehavior(data);
        return addedData;
    }

    private String addedBehavior(String st){
        return st + " ";
    }
}