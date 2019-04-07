public class Decorator implements ICardDecorator {

    private ICardDecorator component;

    public Decorator (ICardDecorator c){
        component = c;
    }

    public String addCharacter(String st){
        return st;
    }
}