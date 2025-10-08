package DesignPatterns.Creational.AbstractFactory.Baeldung;

public class NextGenElectricCar implements ElectricVehicle {
    @Override
    public void build() {
        System.out.println("NextGen Electric Car");
    }
}
