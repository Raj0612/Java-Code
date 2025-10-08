package DesignPatterns.Structural.Decorator.educative;

public class LuxuryFittings1 implements IAircraft {

    IAircraft boeing;

    public LuxuryFittings1(IAircraft boeing) {
        this.boeing = boeing;
    }

    @Override
    public void fly() {
        boeing.fly();
    }

    @Override
    public void land() {
        boeing.land();
    }

    @Override
    public float getWeight() {
        return (30.5f + boeing.getWeight());
    }
}
