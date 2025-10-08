package DesignPatterns.Creational.FactoryMethod.GeekForGeeks.vehicle;

public class Client {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Creator twoWheelerCreator = new Creator(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerCreator.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Creator fourWheelerClient = new Creator(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }
}
