package DesignPatterns.Structural.Decorator.car1;

public class LuxuryDecorator extends CarDecorator {
    public LuxuryDecorator(Car c) {
        super(c);
    }
    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" with Luxury interior");
    }
}
