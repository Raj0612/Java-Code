package DesignPatterns.Structural.Decorator.car;

public class CarBasic implements Car {

    @Override
    public void assemble() {
        System.out.println("Basic Car.");
    }
}