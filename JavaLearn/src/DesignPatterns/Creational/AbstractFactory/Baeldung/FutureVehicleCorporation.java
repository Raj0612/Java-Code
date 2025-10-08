package DesignPatterns.Creational.AbstractFactory.Baeldung;

public class FutureVehicleCorporation extends Corporation{
    @Override
    public MotorVehicle createMotorVehicle() {
        return new FutureVehicleMotorcycle();
    }

    @Override
    public ElectricVehicle createElectricVehicle() {
        return new FutureVehicleElectricCar();
    }
}
