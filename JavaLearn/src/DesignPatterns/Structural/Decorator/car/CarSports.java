package DesignPatterns.Structural.Decorator.car;

public class CarSports extends CarDecorator {

    public CarSports(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println(" Adding features of Sports Car.");
    }
}
