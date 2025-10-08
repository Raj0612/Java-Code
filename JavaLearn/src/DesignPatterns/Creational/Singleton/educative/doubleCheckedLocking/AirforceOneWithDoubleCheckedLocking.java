package DesignPatterns.Creational.Singleton.educative.doubleCheckedLocking;

public class AirforceOneWithDoubleCheckedLocking {

    private volatile static AirforceOneWithDoubleCheckedLocking onlyInstance;
    private AirforceOneWithDoubleCheckedLocking() {
    }
    public void fly() {
        System.out.println("Airforce one is flying...");
    }
    synchronized public static AirforceOneWithDoubleCheckedLocking getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            // Note how we are synchronizing on the class object
            synchronized (AirforceOneWithDoubleCheckedLocking.class) {
                if (onlyInstance == null) {
                    onlyInstance = new AirforceOneWithDoubleCheckedLocking();
                }
            }
        }

        return onlyInstance;
    }
}
