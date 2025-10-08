package DesignPatterns.Creational.Singleton;

public class BillPugh {

    private BillPugh() {
        // private constructor
    }

    private static class BillPughSingleton {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return BillPughSingleton.INSTANCE;
    }
}
