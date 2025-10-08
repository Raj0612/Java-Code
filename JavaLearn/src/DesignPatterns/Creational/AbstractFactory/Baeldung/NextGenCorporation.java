package DesignPatterns.Creational.AbstractFactory.Baeldung;

public class NextGenCorporation extends Corporation {
    @Override
    public MotorVehicle createMotorVehicle() {
        return new NextGenMotorcycle();
    }

    @Override
    public ElectricVehicle createElectricVehicle() {
        return new NextGenElectricCar();
    }
}
