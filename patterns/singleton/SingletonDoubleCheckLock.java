package singleton;

/* double check lock version -- not guaranteed to work prior to Java 5  */

public class SingletonDoubleCheckLock {

    private volatile static SingletonDoubleCheckLock uniqueInstance;

    private SingletonDoubleCheckLock() {
    }

    public static SingletonDoubleCheckLock getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDoubleCheckLock();
                }
            }
        }
        return uniqueInstance;
    }
}


