package DesignPatterns.Creational.FactoryMethod.Dish;

public class Sushi implements Dish {
    @Override
    public void prepare() {
        System.out.println("Preparing sushi...");
    }

    @Override
    public void serve() {
        System.out.println("Serving sushi...");
    }
}
