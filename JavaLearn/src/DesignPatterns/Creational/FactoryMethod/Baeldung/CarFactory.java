package DesignPatterns.Creational.FactoryMethod.Baeldung;

public class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
