package DesignPatterns.Creational.FactoryMethod.vehicle;

public class Client {

    public static void main(String[] args) {
        carFactoryTest();
        motorCycleFactoryTest();
    }

    public static void carFactoryTest(){
        MotorVehicleFactory factory = new CarFactory();
        MotorVehicle car = factory.createMotorVehicle();

        car.build();

        MotorVehicleFactory factory1 = new CarFactory();
        factory1.create();
    }

    public static void motorCycleFactoryTest(){
        MotorVehicleFactory factory = new MotorCycleFactory();
        MotorVehicle motorVehicle = factory.createMotorVehicle();

        motorVehicle.build();
    }
}
