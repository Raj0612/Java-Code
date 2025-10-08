package DesignPatterns.Structural.Decorator.car1;

public class Client {

    public static void main(String[] args) {
        Car realCar = new RealCar();
        realCar.assemble();
        System.out.println("\n*****");

        Car sportsCar = new SportsDecorator(new RealCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsDecorator(new LuxuryDecorator(new RealCar()));
        sportsLuxuryCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryPaintedCar = new SportsDecorator(new LuxuryDecorator(new PaintDecorator(new RealCar())));
        sportsLuxuryPaintedCar.assemble();
        System.out.println("\n*****");

        Car luxuryPaintedCar = new LuxuryDecorator(new PaintDecorator(new RealCar()));
        luxuryPaintedCar.assemble();
        System.out.println("\n*****");

        Car paintedToyCar = new PaintDecorator(new ToyCar());
        paintedToyCar.assemble();
        System.out.println("\n*****");
    }
}
