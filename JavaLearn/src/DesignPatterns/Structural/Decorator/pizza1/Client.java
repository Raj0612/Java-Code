package DesignPatterns.Structural.Decorator.pizza1;

public class Client {

    public static void main(String[] args) {

        Pizza cheesVegPizza = new CheesePizza(new VegPizza(new PizzaPlain()));

        cheesVegPizza.bake();
    }
}
