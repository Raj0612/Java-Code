package DesignPatterns.Creational.Singleton.educative;

public class AirforceOne {

    private static AirforceOne onlyInstance;

    private AirforceOne() {
    }
    public void fly() {
        System.out.println("Airforce one is flying...");
    }

    public static AirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new AirforceOne();
        }

        return onlyInstance;
    }
}
