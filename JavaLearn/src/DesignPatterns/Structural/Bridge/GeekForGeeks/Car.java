package DesignPatterns.Structural.Bridge.GeekForGeeks;

// Refine abstraction 1 in bridge pattern -- Extends the abstraction takes the finer detail one level below. Hides the finer elements from implementers.
public class Car extends Vehicle {
    public Car(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}
