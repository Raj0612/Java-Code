package DesignPatterns.Structural.Decorator.car1;

public class SportsDecorator extends CarDecorator {
    public SportsDecorator(Car c) {
        super(c);
    }
    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" with Sports mode");
    }
}
