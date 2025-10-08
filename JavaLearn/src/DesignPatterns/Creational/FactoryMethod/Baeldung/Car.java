package DesignPatterns.Creational.FactoryMethod.Baeldung;

public class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
