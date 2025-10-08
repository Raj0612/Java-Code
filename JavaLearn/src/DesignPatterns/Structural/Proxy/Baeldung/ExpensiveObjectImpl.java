package DesignPatterns.Structural.Proxy.Baeldung;

public class ExpensiveObjectImpl implements ExpensiveObject{
    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        System.out.println("processing complete.");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Loading initial configuration...");
    }
}
