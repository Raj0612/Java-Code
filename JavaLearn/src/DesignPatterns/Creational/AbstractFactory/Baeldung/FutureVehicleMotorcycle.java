package DesignPatterns.Creational.AbstractFactory.Baeldung;

public class FutureVehicleMotorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Future Vehicle Motorcycle");
    }
}
