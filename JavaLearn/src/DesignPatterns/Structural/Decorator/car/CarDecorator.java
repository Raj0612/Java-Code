package DesignPatterns.Structural.Decorator.car;

public class CarDecorator implements  Car{

    Car car;

    public CarDecorator(Car car){
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}
