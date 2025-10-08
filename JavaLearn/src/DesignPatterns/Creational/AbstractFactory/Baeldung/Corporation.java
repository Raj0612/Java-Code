package DesignPatterns.Creational.AbstractFactory.Baeldung;

public abstract class Corporation {
    public abstract MotorVehicle createMotorVehicle();

    public abstract ElectricVehicle createElectricVehicle();
}
