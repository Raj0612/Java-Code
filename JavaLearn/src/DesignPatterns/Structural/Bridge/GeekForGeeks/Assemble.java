package DesignPatterns.Structural.Bridge.GeekForGeeks;

// Concrete implementation 1 for bridge pattern
public class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.print(" And");
        System.out.println(" Assembled.");
    }
}
