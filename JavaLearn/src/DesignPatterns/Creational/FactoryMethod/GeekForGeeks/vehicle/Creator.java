package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.vehicle;

public class Creator {
    private Vehicle pVehicle;

    public Creator(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}
