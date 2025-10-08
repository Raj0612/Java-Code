package DesignPatterns.Structural.Decorator.car;

public class CarLuxury extends CarDecorator {

    public CarLuxury(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println(" Adding features of Luxury Car.");
    }
}