package DesignPatterns.Structural.Decorator.car1;

public class RealCar implements Car{
    @Override
    public void assemble() {
        System.out.print("Real Car");
    }
}
