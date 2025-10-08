package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.vehicle;

public class TwoWheelerFactory implements VehicleFactory{
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}
