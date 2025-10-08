package DesignPatterns.Creational.SimpleFactory.pizza;

public class PizzaVeg implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veg Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veg Pizza");
    }
}
