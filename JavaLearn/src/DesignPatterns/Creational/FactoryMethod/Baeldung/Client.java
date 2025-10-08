package DesignPatterns.Creational.FactoryMethod.Baeldung;

public class Client {

    public static void main(String[] args) {
        MotorVehicleFactory factory = new CarFactory();
        MotorVehicle car = factory.createMotorVehicle();
        car.build();

        MotorVehicle car1 = factory.create();
        System.out.println("car1 " + car1);

        MotorVehicleFactory factory1 = new MotorcycleFactory();
        MotorVehicle motorcycle = factory1.createMotorVehicle();
        motorcycle.build();
    }
}
