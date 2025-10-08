package DesignPatterns.Creational.FactoryMethod.vehicle;

public class MotorCycleFactory extends MotorVehicleFactory {
    @Override
    public MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}
