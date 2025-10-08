package DesignPatterns.Creational.FactoryMethod.vehicle;

public class Motorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}
