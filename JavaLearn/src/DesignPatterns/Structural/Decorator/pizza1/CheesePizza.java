package DesignPatterns.Structural.Decorator.pizza1;

public class CheesePizza implements Pizza{

    Pizza pizza;
    public CheesePizza(Pizza pizza){
        this.pizza = pizza;

    }
    @Override
    public void bake() {
        pizza.bake();
        System.out.println("Adding Cheese");
    }
}
