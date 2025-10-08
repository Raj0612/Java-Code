package DesignPatterns.Structural.Decorator.car;

public class Client {
    public static void main(String[] args) {

        Car car = new CarBasic();
        car.assemble();
        System.out.println("");
        Car car1 = new CarDecorator(car);
        car1.assemble();
        System.out.println();
        Car car2 = new CarLuxury(new CarSports(new CarBasic()));
        car2.assemble();
        System.out.println();
        Car car3 = new CarDecorator(new CarSports(new CarLuxury(new CarBasic())));
        car3.assemble();
    }
}
