package DesignPatterns.Structural.Bridge.GeekForGeeks;

// abstraction in bridge pattern --  core of the bridge design pattern and defines the crux. Contains a reference to the implementer.
public abstract class Vehicle {

    protected Workshop workShop1;
    protected Workshop workShop2;

    protected Vehicle(Workshop workShop1, Workshop workShop2) {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}
