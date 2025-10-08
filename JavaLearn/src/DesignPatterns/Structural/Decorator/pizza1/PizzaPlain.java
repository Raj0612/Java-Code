package DesignPatterns.Structural.Decorator.pizza1;


public class PizzaPlain implements Pizza {

    public PizzaPlain(){

    }
    @Override
    public void bake() {
        System.out.println("Baking Plain Pizza");
    }
}
