package DesignPatterns.Structural.Bridge.GeekForGeeks;

// Refine abstraction 1 in bridge pattern -- Extends the abstraction takes the finer detail one level below. Hides the finer elements from implementers.
public class Bike extends Vehicle {
    public Bike(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }
}
