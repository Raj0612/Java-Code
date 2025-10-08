package DesignPatterns.Creational.AbstractFactory.car;

public class Client {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.MICRO, Location.INDIA));
        System.out.println(CarFactory.buildCar(CarType.MINI, Location.DEFAULT));
        System.out.println(CarFactory.buildCar(CarType.LUXURY, Location.USA));
    }

}
