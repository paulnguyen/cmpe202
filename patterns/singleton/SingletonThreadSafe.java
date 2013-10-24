package singleton;

/* thread safe version */

public class SingletonThreadSafe {

    private static SingletonThreadSafe uniqueInstance;

    private SingletonThreadSafe() {
    }

    public static synchronized SingletonThreadSafe getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonThreadSafe();
        }
        return uniqueInstance;
    }

}

