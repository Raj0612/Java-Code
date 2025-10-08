package DesignPatterns.Structural.Decorator.pizza1;

public class VegPizza implements Pizza{

    Pizza pizza;
    public VegPizza(Pizza pizza){
        this.pizza = pizza;

    }
    @Override
    public void bake() {
        pizza.bake();
        System.out.println("Adding Vegetables");
    }
}
