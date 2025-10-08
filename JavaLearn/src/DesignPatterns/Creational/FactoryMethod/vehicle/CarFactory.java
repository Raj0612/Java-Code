package DesignPatterns.Creational.FactoryMethod.vehicle;

public class CarFactory extends MotorVehicleFactory {
    @Override
    public MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
