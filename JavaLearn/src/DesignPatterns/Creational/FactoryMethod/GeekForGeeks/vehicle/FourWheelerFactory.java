package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.vehicle;

public class FourWheelerFactory implements VehicleFactory{
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}
