package DesignPatterns.Structural.Decorator.pizza;

public class PizzaPlain implements Pizza{
    @Override
    public void bake() {
        System.out.println("Baking Plain Pizza");
    }
}
