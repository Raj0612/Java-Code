package DesignPatterns.Creational.AbstractFactory.GeekForGeeks;

public class Client {

    public static void main(String[] args) {
        CarFactory northAmericaFactory = new NorthAmericaCarFactory();
        Car northAmericaCar = northAmericaFactory.createCar();
        CarSpecification northAmericaSpec = northAmericaFactory.createSpecification();
        northAmericaCar.assemble();
        northAmericaSpec.display();


        CarFactory europeFactory = new EuropeCarFactory();
        Car europeCar = europeFactory.createCar();
        CarSpecification europeSpec = europeFactory.createSpecification();
        europeCar.assemble();
        europeSpec.display();
    }
}
