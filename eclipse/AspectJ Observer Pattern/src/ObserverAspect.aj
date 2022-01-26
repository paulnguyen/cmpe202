import java.util.ArrayList;

public aspect ObserverAspect {

    // Declarations
    declare parents: TheEconomy implements Subject;
    declare parents: Optimist implements Observer;
    declare parents: Pessimist implements Observer;

    // Subject Introductions
    private ArrayList<Observer> Subject.observers = new ArrayList<Observer>() ;
    public void Subject.attach(Observer obj) {
        observers.add(obj);
        obj.setSubject(this);
    }
    public void Subject.detach(Observer obj) {
        observers.remove(obj);
        obj.setSubject(null);
    }
    public void Subject.notifyObservers() {
        for (Observer obj  : observers)
        {
            obj.update();
        }
    }

    // Observer Introductions
    private Subject Observer.subject = null;
    public void     Observer.setSubject(Subject s) { subject = s; }
    public Subject  Observer.getSubject() { return subject; }

    // Target Introductions
    public void Optimist.update() {
        this.setEconomy ( ((TheEconomy)subject).getState() );
    }
    public void Pessimist.update() {
        this.setEconomy ( ((TheEconomy)subject).getState() ) ;
    }

    // PointCut
    after(Subject s): target(s) && call(void TheEconomy.setState(..)) {
        System.out.println( "Notifying Observers..." );
        s.notifyObservers() ;
    }


}
