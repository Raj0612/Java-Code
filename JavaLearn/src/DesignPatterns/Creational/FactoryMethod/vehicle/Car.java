package DesignPatterns.Creational.FactoryMethod.vehicle;

public class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
